package com.workflow.activiti.listener;

import com.workflow.entity.Order;
import com.workflow.service.OrderManagerService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 调整工单内容处理器
 *
 * @author chentt
 */
@Component
@Transactional
public class AfterModifyApplyContentProcessor implements TaskListener {

    private static final long serialVersionUID = 1L;

    @Autowired
    private OrderManagerService orderManagerService;

    @Autowired
    RuntimeService runtimeService;

    public void notify(DelegateTask delegateTask) {
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        Order queryOrder = new Order();
        queryOrder.setId(new Integer(processInstance.getBusinessKey()));

        Order order = orderManagerService.queryOrderById(queryOrder);

        Order orderVariables = (Order) delegateTask.getVariable("order");

        order.setOrderType(orderVariables.getOrderType());
        order.setContent(orderVariables.getContent());

        orderManagerService.saveOrder(order);
    }

}
