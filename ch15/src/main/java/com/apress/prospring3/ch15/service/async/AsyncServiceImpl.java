/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch15.service.async;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.apress.prospring3.ch15.service.AsyncService;

/**
 * @author Clarence
 *
 */
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {

	final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
	
	@Async
	public void asyncTask() {

		logger.info("Start execution of async. task");
		
		try {
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		logger.info("Complete execution of async. task");
		
	}

	@Async
	public Future<String> asyncWithReturn(String name) {

		logger.info("Start execution of async. task with return");
		
		try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		logger.info("Complete execution of async. task with return");
		
		return new AsyncResult<String>("Hello: " + name);
		
	}
}
