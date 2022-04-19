package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilities.HTMLReport;

public class ProjectWrappers extends HTMLReport implements GenericWrappers {
	
	@BeforeSuite
   public void beforeSuite() {
		startReport();
	
	}
	@AfterSuite
	public void afterSuite() {
		endReport();
		
	}
	@BeforeTest
	public void beforeTest() {
		readProperties();
		
	}
	@AfterTest
	public void afterTest() {
		prop=null;
	}
	
	@BeforeMethod
	public void beforeMethod() {
		startTest(TestCaseName, TestCaseDescription);
		test.assignAuthor(TestCaseAuthor);
		test.assignCategory(TestCaseCatergeory);
		invokeApp("chrome","https://www.amazon.co.uk/");
		
	}
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
		
	}
	@AfterClass
	public void afterClass() {
		endTest();
		
	}

}
