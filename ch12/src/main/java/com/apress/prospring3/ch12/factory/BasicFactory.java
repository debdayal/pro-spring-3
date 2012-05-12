/**
 * Created on Nov 2, 2011
 */
package com.apress.prospring3.ch12.factory;

import com.apress.prospring3.ch12.service.OrderService;
import com.apress.prospring3.ch12.service.impl.DefaultOrderServiceImpl;

/**
 * @author Clarence
 * 
 */
public class BasicFactory {
	private static final BasicFactory instance;
	private OrderService orderService;

	static {
		instance = new BasicFactory();
	}

	public static BasicFactory getlnstance() {
		return instance;
	}

	public BasicFactory() {
		this.orderService = new DefaultOrderServiceImpl();
	}

	public OrderService getOrderService() {
		return this.orderService;
	}
}
