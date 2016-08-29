package com.workflow.service.impl;

import com.workflow.dao.OrderDao;
import com.workflow.entity.Order;
import com.workflow.service.OrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 请假实体管理
 *
 * @author Chentt
 */
@Service
public class OrderManagerServiceImpl implements OrderManagerService {

    @Autowired
    private OrderDao orderDao;


    @Transactional(readOnly = false)
    public int saveOrder(Order entity) {
        return orderDao.insertOrder(entity);
    }

    public void updateOrderProcessInstanceId(Order entity){
        orderDao.updateOrderProcessInstanceId(entity);
    }

    public Order queryOrderById(Order order){
        return orderDao.selectOrderById(order);
    }

    public void updateOrder(Order entity){
         orderDao.updateOrder(entity);
    }

}
