package com.workflow.web.order;


import com.workflow.entity.Order;
import com.workflow.service.OrderManagerService;
import com.workflow.service.OrderWorkflowService;
import com.workflow.util.*;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请假控制器，包含保存、启动流程
 *
 * @author Chentt
 */
@Controller
@RequestMapping(value = "/oa/leave")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected OrderWorkflowService workflowService;

    @Autowired
    protected OrderManagerService orderManagerService;


    @RequestMapping(value = {"apply", ""})
    public String createForm(Model model) {
        model.addAttribute("leave", new Order());
        return "/order/leaveApply";
    }


    /**
     * 启动工单流程
     *
     * @param
     */
    @RequestMapping(value = "start", method = RequestMethod.POST)
    public String startWorkflow(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session) {

        String content = request.getParameter("content");
        String orderType = request.getParameter("orderType");

        Order order = new Order();
        order.setOrderType(orderType);
        order.setContent(content);
        try {


            User user = UserUtil.getUserFromSession(session);
            // 用户未登录不能操作，实际应用使用权限框架实现，例如Spring Security、Shiro等
            if (user == null || StringUtils.isBlank(user.getId())) {
                return "redirect:/login?timeout=true";
            }
            order.setUserId(user.getId());
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("roleId",orderType);
            variables.put("order",order);
            ProcessInstance processInstance = workflowService.startWorkflow(order, variables);
            redirectAttributes.addFlashAttribute("message", "流程已启动，流程ID：" + processInstance.getId());
        } catch (ActivitiException e) {
            if (e.getMessage().indexOf("no processes deployed with key") != -1) {
                logger.warn("没有部署流程!", e);
                redirectAttributes.addFlashAttribute("error", "没有部署流程，请在[工作流]->[流程管理]页面点击<重新部署流程>");
            } else {
                logger.error("启动请假流程失败：", e);
                redirectAttributes.addFlashAttribute("error", "系统内部错误！");
            }
        } catch (Exception e) {
            logger.error("启动请假流程失败：", e);
            redirectAttributes.addFlashAttribute("error", "系统内部错误！");
        }
        return "redirect:/oa/leave/apply";
    }

    /**
     * 任务列表
     *
     * @param request
     */
    @RequestMapping(value = "list/task")
    public ModelAndView taskList(HttpSession session, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/order/taskList");
        Page<Order> page = new Page<Order>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        String userId = UserUtil.findUserId(session);
        workflowService.findTodoTasks(userId, page, pageParams);
        mav.addObject("page", page);
        return mav;
    }
    /**
     * 任务列表
     *
     * @param request
     */
    @RequestMapping(value = "taskList")
    @ResponseBody
    public ResponseInfo taskListRest(HttpSession session, HttpServletRequest request) {
        Page<Map<String, Object>> page = new Page<Map<String, Object>>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        String userId = UserUtil.findUserId(session);
        List<Map<String, Object>> orderList =  workflowService.findTodoTasksMap(userId, page, pageParams);

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(0);
        responseInfo.setMsg("查询列表");
        responseInfo.setData(orderList);

        return responseInfo;
    }



    /**
     * 读取运行中的流程实例
     *
     * @return
     */
    @RequestMapping(value = "list/running")
    public ModelAndView runningList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/order/running");
        Page<Order> page = new Page<Order>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        workflowService.findRunningProcessInstaces(page, pageParams);
        mav.addObject("page", page);
        return mav;
    }
    /**
     * 读取详细数据
     *
     * @param id
     * @return
     */
        @RequestMapping(value = "detail/{id}")
        @ResponseBody
        public Order getLeave(@PathVariable("id") Integer id) {
            Order query = new Order();
            query.setId(id);
            Order order = orderManagerService.queryOrderById(query);
            return order;
        }


    /**
     *  * 完成任务
     *
     * @param taskId
     * @return
     */
    @RequestMapping(value = "complete/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String complete(@PathVariable("id") String taskId, Variable var) {
        try {

            taskService.createTaskQuery().taskId(taskId).includeProcessVariables();
            //String roleId = (String) taskService.getVariable(taskId, "roleId");
            Map<String, Object> variables = var.getVariableMap();
            /*variables.put("roleId",roleId);*/
            taskService.complete(taskId, variables);
            return "success";
        } catch (Exception e) {
            logger.error("error on complete task {}, variables={}", new Object[]{taskId, var.getVariableMap(), e});
            return "error";
        }
    }
    /*
     * 读取运行中的流程实例
     *
     * @return
     */

    @RequestMapping(value = "list/finished")
    public ModelAndView finishedList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/order/finished");
        Page<Order> page = new Page<Order>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        workflowService.findFinishedProcessInstaces(page, pageParams);
        mav.addObject("page", page);
        return mav;
    }

    /*
     * 签收任务
     */

    @RequestMapping(value = "task/claim/{id}")
    public String claim(@PathVariable("id") String taskId, HttpSession session, RedirectAttributes redirectAttributes) {
        String userId = UserUtil.findUserId(session);
        taskService.claim(taskId, userId);
        redirectAttributes.addFlashAttribute("message", "任务已签收");
        return "redirect:/oa/leave/list/task";
    }


    /*
     * 读取详细数据
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "detail-with-vars/{id}/{taskId}")
    @ResponseBody
    public Order getLeaveWithVars(@PathVariable("id") Integer id, @PathVariable("taskId") String taskId) {

        Order query = new Order();
        query.setId(id);
        Order order = orderManagerService.queryOrderById(query);
        Map<String, Object> variables = taskService.getVariables(taskId);

        variables.put("content",order.getContent());
        variables.put("orderType",order.getOrderType());
        order.setVariables(variables);
        return order;
    }




}
