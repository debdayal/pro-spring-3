/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch20;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch20.domain.Hobby;
import com.apress.prospring3.ch20.service.HobbyService;

/**
 * @author Clarence
 *
 */
public class HobbyServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		System.out.println("App context initialized successfully");
		
		HobbyService hobbyService = ctx.getBean("hobbyService", HobbyService.class);
		
		List<Hobby> hobbies = hobbyService.findAll();
		
		for (Hobby hobby: hobbies) {
			System.out.println(hobby.getHobbyId());
		}

	}

}
