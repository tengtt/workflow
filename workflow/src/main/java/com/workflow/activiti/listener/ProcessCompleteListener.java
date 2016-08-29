package com.workflow.activiti.listener;

import com.workflow.dao.OrderDao;
import com.workflow.entity.Order;
import com.workflow.util.ApplicationContextUtils;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.context.ApplicationContext;

import java.util.Date;

/**
 * 
 * <p>
 * Title: ProcessCompleteListener
 * </p>
 * <p>
 * Description:流程执行完成的监听器
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-23上午11:14:29
 * @version 1.0
 */
public class ProcessCompleteListener implements ExecutionListener {

	// 通过工具类获取spring容器
	private static ApplicationContext applicationContext = ApplicationContextUtils
			.getApplicationContext();

	@Override
	public void notify(DelegateExecution execution) throws Exception {

		// execution是流程实例 的代理对象
		// 业务标识，即采购单id
		String businessKey = execution.getBusinessKey();

		//从spring容器中得到mapper
		OrderDao orderDao =  (OrderDao) applicationContext.getBean("orderDao");

		//根据 采购单id更新status状态值为complete
		Order order = new Order();
		order.setId(Integer.parseInt(businessKey));
		order.setEndTime(new Date());
		order.setStatus("complete");

		orderDao.updateOrder(order);
	}

}
