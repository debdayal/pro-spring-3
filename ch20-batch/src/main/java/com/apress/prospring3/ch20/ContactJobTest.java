/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch20;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class ContactJobTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
			
		JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);

		Job contactJob = ctx.getBean("importContactsJob", Job.class);
				
		Map<String, JobParameter> jobParamMap = new HashMap<String, JobParameter>();
			jobParamMap.put("inputFile", new JobParameter("C:/temp/contacts.xml"));
				
		try {
		jobLauncher.run(contactJob, new JobParameters(jobParamMap)); 
		} catch (Exception ex) {
		ex.printStackTrace();
		}
				
		System.out.println("Contact import job completed successfully");

	}

}
