/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Clarence
 *
 */
@Configuration
@Import(OtherConfig.class)
// XML: <import resource="classpath:events/events.xml")
@ImportResource(value="classpath:events/events.xml")
// XML: <context:property-placeholder location="classpath:message.properties"/>
@PropertySource(value="classpath:message.properties")
// XML: <context:component-scan base-package="com.apress.prospring3.ch5.context"/> 
@ComponentScan(basePackages={"com.apress.prospring3.ch5.context"})
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	Environment env;
	
	// XML: 
	// <bean id="messageProvider" class="com.apress.prospring3.ch5.javaconfig.ConfigurableMessageProvider"/>
	@Bean
	@Lazy(value=true)   //XML <bean .... lazy-init="true"/>
	public MessageProvider messageProvider() {
		// Constructor injection
		return new ConfigurableMessageProvider(env.getProperty("message"));
	}
	
	// XML: 
    // <bean id="messageRenderer" class="com.apress.prospring3.ch5.javaconfig.StandardOutMessageRenderer"
    //        p:messageProvider-ref="messageProvider"/>	
	@Bean(name="messageRenderer")
	@Scope(value="prototype")  // XML: <bean ... scope="prototype"/>
	@DependsOn(value="messageProvider")  // XML: <bean ... depends-on="messageProvider"/>
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		
		// Setter injection
		renderer.setMessageProvider(messageProvider());
		
		return renderer;
	}
	
}
