package com.workflow.dao;

import com.workflow.entity.Order;

/**
 * 请假实体管理接口
 *
 * @author Chentt
 */

public interface OrderDao {


    public int insertOrder(Order order);

    public void updateOrderProcessInstanceId(Order order);

    public void updateOrder(Order entity);

    public Order selectOrderById(Order order);
}
