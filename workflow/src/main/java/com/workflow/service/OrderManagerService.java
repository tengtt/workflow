package com.workflow.service;

import com.workflow.entity.Order;
import org.springframework.stereotype.Service;

/**
 * Created by teng on 2016/8/9.
 */

@Service
public interface OrderManagerService {

    public int saveOrder(Order entity);

    public void updateOrderProcessInstanceId(Order entity);

    public void updateOrder(Order entity);

    public Order queryOrderById(Order order);
}
