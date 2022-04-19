package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HTMLReport {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String TestCaseName,TestCaseDescription,TestCaseAuthor,TestCaseCatergeory;
	
	public void startReport() {
		extent=new ExtentReports("./reports/report.html");
	}
	public void startTest(String testname,String description) {
		test=extent.startTest(testname,description);
		
	}
	public void endTest() {
		extent.endTest(test);
	}
	public void endReport() {
		extent.flush();
		
		
	}
	
	
	

}
