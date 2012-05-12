/**
 * Created on Nov 2, 2011
 */
package com.apress.prospring3.ch12.factory;

import com.apress.prospring3.ch12.service.OrderService;
import com.apress.prospring3.ch12.service.impl.DefaultOrderServiceImpl;
import com.apress.prospring3.ch12.service.impl.SuperOrderServiceImpl;

/**
 * @author Clarence
 * 
 */
public class MultiFactory {
	private static final BasicFactory instance;
	private OrderService orderService;
	private OrderService superOrderService;
	static {
		instance = new BasicFactory();
	}

	public static BasicFactory getInstance() {
		return instance;
	}

	public MultiFactory() {
		this.orderService = new DefaultOrderServiceImpl();
		this.superOrderService = new SuperOrderServiceImpl();
	}

	public OrderService getOrderService() {
		return this.orderService;
	}

	public OrderService getSuperOrderService() {
		return this.superOrderService;
	}

}
