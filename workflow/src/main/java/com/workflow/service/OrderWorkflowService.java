package com.workflow.service;

import com.workflow.entity.Order;
import com.workflow.util.Page;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 请假流程Service
 *
 * @author chentt
 */
@Component
@Transactional
public class OrderWorkflowService {

    private static Logger logger = LoggerFactory.getLogger(OrderWorkflowService.class);

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected HistoryService historyService;

    @Autowired
    protected RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private OrderManagerService leaveManagerService;

    /**
     * 启动流程
     *
     * @param entity
     */
    public ProcessInstance startWorkflow(Order entity, Map<String, Object> variables) {
        entity.setStartTime(new Date());
        leaveManagerService.saveOrder(entity);
        Integer id = entity.getId();
        logger.debug("save entity: {}", entity);
        String businessKey = id + "";

        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getUserId());

            processInstance = runtimeService.startProcessInstanceByKey("orderFlow", businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity.setProcessInstanceId(processInstanceId);
            leaveManagerService.updateOrderProcessInstanceId(entity);
            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"orderFlow", businessKey, processInstanceId, variables});
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }
    /**
     * 查询待办任务
     *
     * @param userId 用户ID
     * @return
     */
    @Transactional(readOnly = true)
    public List<Order> findTodoTasks(String userId, Page<Order> page, int[] pageParams) {
        List<Order> results = new ArrayList<Order>();

        // 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
        List<Task> tasks = taskQuery.list();

        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey;
            if(processInstance == null){
                continue;
            }else {
                businessKey = processInstance.getBusinessKey();
                if (businessKey == null) {
                    continue;
                }
            }

            Order queryOrder = new Order();
            queryOrder.setId(new Integer(businessKey));

            Order order = leaveManagerService.queryOrderById(queryOrder);
            order.setTask(task);
            order.setProcessInstance(processInstance);
            order.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            results.add(order);
        }

        page.setTotalCount(taskQuery.count());
        page.setResult(results);
        return results;
    }
    @Transactional(readOnly = true)
    public List<Map<String,Object>> findTodoTasksMap(String userId, Page<Map<String, Object>> page, int[] pageParams) {
        List<Map<String,Object>> results = new ArrayList();

        // 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
        List<Task> tasks = taskQuery.list();

        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey;
            if(processInstance == null){
                continue;
            }else {
                businessKey = processInstance.getBusinessKey();
                if (businessKey == null) {
                    continue;
                }
            }

            Order queryOrder = new Order();
            queryOrder.setId(new Integer(businessKey));

            Map<String,Object> map = new HashMap<String, Object>();
            map.put("taskAssignee",task.getAssignee());
            map.put("processInstanceId",task.getProcessInstanceId());
            map.put("businessKey",processInstance.getBusinessKey());
            map.put("processDefinitionKey",processInstance.getProcessDefinitionKey());
            results.add(map);
        }

        page.setTotalCount(taskQuery.count());
        page.setResult(results);
        return results;
    }



    /**
     * 读取运行中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Order> findRunningProcessInstaces(Page<Order> page, int[] pageParams) {
        List<Order> results = new ArrayList<Order>();
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey("orderFlow").active().orderByProcessInstanceId().desc();
        List<ProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

        // 关联业务实体
        for (ProcessInstance processInstance : list) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            Order queryOrder = new Order();
            queryOrder.setId(new Integer(businessKey));

            Order order = leaveManagerService.queryOrderById(queryOrder);
            order.setProcessInstance(processInstance);
            order.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            results.add(order);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().listPage(0, 1);
            order.setTask(tasks.get(0));
        }

        page.setTotalCount(query.count());
        page.setResult(results);
        return results;
    }

    /**
     * 读取已结束中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Order> findFinishedProcessInstaces(Page<Order> page, int[] pageParams) {
        List<Order> results = new ArrayList<Order>();
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("orderFlow").finished().orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

        // 关联业务实体
        for (HistoricProcessInstance historicProcessInstance : list) {
            String businessKey = historicProcessInstance.getBusinessKey();
            Order queryOrder = new Order();
            queryOrder.setId(new Integer(businessKey));

            Order order = leaveManagerService.queryOrderById(queryOrder);
            order.setProcessDefinition(getProcessDefinition(historicProcessInstance.getProcessDefinitionId()));
            order.setHistoricProcessInstance(historicProcessInstance);
            results.add(order);
        }
        page.setTotalCount(query.count());
        page.setResult(results);
        return results;
    }

    /**
     * 查询流程定义对象
     *
     * @param processDefinitionId 流程定义ID
     * @return
     */
    protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        return processDefinition;
    }


}
