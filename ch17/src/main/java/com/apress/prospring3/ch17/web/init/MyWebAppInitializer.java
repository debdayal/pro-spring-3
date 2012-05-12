/**
 * Created on Dec 26, 2011
 */
package com.apress.prospring3.ch17.web.init;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Clarence
 *
 */
public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		
		appContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
		
	    ServletRegistration.Dynamic dispatcher = container.addServlet("appServlet", new DispatcherServlet(appContext));

	    MultipartConfigElement multipartConfigElement = new MultipartConfigElement(null, 5000000, 5000000, 0);
	    dispatcher.setMultipartConfig(multipartConfigElement);
	    
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("/");		
		
	}	
	
}
