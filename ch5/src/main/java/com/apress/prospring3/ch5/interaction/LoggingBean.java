/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.interaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author clarence
 */
public class LoggingBean implements BeanNameAware {

    private static final Log log = LogFactory.getLog(LoggingBean.class);
    
    private String beanName = null;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
    
    public void someOperation() {
        if(log.isInfoEnabled()) {
            log.info("Bean [" + beanName + "] - someOperation()");
        }
    }
}
