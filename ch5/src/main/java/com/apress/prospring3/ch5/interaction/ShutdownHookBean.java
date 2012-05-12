/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.interaction;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author clarence
 */
public class ShutdownHookBean implements ApplicationContextAware {

    private ApplicationContext ctx;

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {

		if (ctx instanceof GenericApplicationContext) {
			((GenericApplicationContext) ctx).registerShutdownHook();
		}
		
	}

}