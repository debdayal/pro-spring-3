/**
 * Created on Jan 5, 2012
 */
package com.apress.prospring3.ch19.test.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.SeleneseTestBase;

/**
 * @author Clarence
 *
 */
public class UIAddContactTest extends SeleneseTestBase {

	private static final String USERNAME = "user";
	private static final String PASSWORD = "user";
	
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}
	
	@Test
	public void testAddContact() {
		
		// Login
		loginAs(USERNAME, PASSWORD);
		
		// Enter add contact form
		selenium.open("/ch19/contacts?form");
		selenium.waitForPageToLoad("30000");
		
		// Fill in contact information
		selenium.type("firstName", "Andy");
		selenium.type("lastName", "Lau");
		selenium.click("name=submit");
		
		// Verification
		verifyTrue(selenium.isTextPresent("Andy"));
		verifyTrue(selenium.isTextPresent("Lau"));
		
		// Logout
		logout();
	}
	
	@Test
	public void testAddContactWithEmptyForm() {
		
		// Login
		loginAs(USERNAME, PASSWORD);
		
		// Enter add contact form
		selenium.open("/ch19/contacts?form");
		selenium.waitForPageToLoad("30000");
		
		// Submit form
		selenium.click("name=submit");
		
		// Verification
		verifyTrue(selenium.isTextPresent("Failed saving contact"));
		
		// Logout
		logout();
	}	
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}	
	
	private void loginAs(String userName, String password) {
		selenium.open("/ch19/contacts");
		selenium.type("j_username", userName);
		selenium.type("j_password", password);
		selenium.click("name=login");
		selenium.waitForPageToLoad("30000");		
	}
	
	private void logout() {
		selenium.click("link=Logout");
	}
	
}
