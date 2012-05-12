/**
 * Created on Jan 4, 2012
 */
package com.apress.prospring3.ch19.test.listener;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import com.apress.prospring3.ch19.test.annotation.DataSets;

/**
 * @author Clarence
 *
 */
public class ServiceTestExecutionListener implements TestExecutionListener {

	private IDatabaseTester databaseTester;
	
	public void afterTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub		
	}

	public void afterTestMethod(TestContext arg0) throws Exception {
		// Clear up testing data if exists
		if (databaseTester != null) {			
			databaseTester.onTearDown();
		}				
	}

	public void beforeTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub		
	}

	public void beforeTestMethod(TestContext testCtx) throws Exception {

		// Check for existence of DataSets annotation for the method under testing
		DataSets dataSetAnnotation = testCtx.getTestMethod().getAnnotation(DataSets.class);
		
		if ( dataSetAnnotation == null ) {
			return;
		}
		
		String dataSetName = dataSetAnnotation.setUpDataSet();

		// Populate data set if data set name exists
		if ( ! dataSetName.equals("") ) {
			databaseTester = (IDatabaseTester) testCtx.getApplicationContext().getBean("databaseTester");
			XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader) testCtx.getApplicationContext().getBean("xlsDataFileLoader");
			IDataSet dataSet = xlsDataFileLoader.load(dataSetName);
	
			databaseTester.setDataSet(dataSet);	
			databaseTester.onSetup();
		}
	}

	public void prepareTestInstance(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub
	}	
	
}
