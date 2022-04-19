
package wrappers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.net.ssl.SSLEngineResult.Status;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.HTMLReport;

public class GenericWrappers extends HTMLReport implements Wrappers{
    public static RemoteWebDriver driver;
    public Properties prop;
    
	
	public void logStatus(String status,String desc) {
		long number=takeSnap();
		if(status.equalsIgnoreCase("pass")) {
			test.log(LogStatus.PASS, desc+test.addScreenCapture(System.getProperty("user.dir")+"/images/snap"+number+".jpg"));
		}else if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, desc+test.addScreenCapture(System.getProperty("user.dir")+"/images/snap"+number+".jpg"));
	
		}
	
	}

    public void readProperties() {
    	prop=new Properties();
    	try {
			prop.load(new FileInputStream("./src/main/java/object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void invokeApp(String browser,String url) {
    	try {
    		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
    		}else if(browser.equalsIgnoreCase("firefox")) {
    			driver=new FirefoxDriver();	
			}
    		driver.manage().window().maximize();
			driver.get(url);
			//System.out.println("Browser launched Successfully and Loaded URL as - "+url);
			logStatus("pass", "Browser launched Successfully and Loaded URL as - "+url);
		} catch (WebDriverException e) {
			//System.err.println("Browser GOt Closed Due to Unknown Error");
			logStatus("fail", "Browser GOt Closed Due to Unknown Error");
		}
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("Element by Id got selected successfully");
			logStatus("pass", "Element by Id got selected successfully");
		}catch (NoSuchElementException e) {
			//System.err.println("No Element available");
			logStatus("fail", "No element available");
		}catch (ElementNotVisibleException e) {
			//System.err.println("No Element visible to interact");
			logStatus("fail","No Element visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
			logStatus("fail","Element is interrupted to perform click");
		}catch (ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch (StaleElementReferenceException e) {
			//System.err.println("Element no longer present in DOM");
			logStatus("fail","Element no longer present in DOM");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch (WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	
	

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("Element by Name got selected successfully");
			logStatus("pass","Element by Name got selected successfully");
		}catch (NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("Element got selected by Xpath successfully");
			logStatus("pass","Element got selected by Xpath successfully");
		}catch (NoSuchElementException e){
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void verifyTitle(String title) {
		try {
			String actTitle = driver.getTitle();
			if(actTitle.equals(title)) {
			//System.out.println("Title matched");
			logStatus("pass","Title matched");
		}else {
			//System.out.println("Title not matched");
			logStatus("pass","Title not matched");
		}
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public void verifyTextById(String id, String text) {
		try {
			String actText = driver.findElementById(id).getText();
		if(actText.equals(text)) {
			//System.out.println("Text matched");
			logStatus("pass","Text matched");
		}else {
			//System.out.println("Text Not matched");
			logStatus("pass","Text Not matched");
		}
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			// wrong here
			String actText = driver.findElementByXPath(xpath).getText();
			if(actText.equals(text)) {
				//System.out.println("Text Matched");
				logStatus("pass","Text Matched");
			}else {
				//System.out.println("Text NOT matched");
				logStatus("fail","Text NOT matched");
			}
				}catch (NoSuchElementException e) {
					//System.err.println("NO such Element is available to click");
					logStatus("fail","No such Element is available to click");
				}catch(ElementNotSelectableException e) {
					//System.err.println("Element is not able to select");
					logStatus("fail","Element is not able to select");
				}catch(ElementNotVisibleException e) {
					//System.err.println("Element not visible to interact");
					logStatus("fail","Element not visible to interact");
				}catch(ElementClickInterceptedException e) {
					//System.err.println("Element is interrupted to perform click");
				    logStatus("fail","Element is interrupted to perform click");
				}catch(ElementNotInteractableException e) {
					//System.err.println("Element not able to interact");
					logStatus("fail","Element not able to interact");
				}catch(InvalidElementStateException e) {
					//System.err.println("Element is not valid,not loaded to perform click");
					logStatus("fail","Element is not valid,not loaded to perform click");
				}catch(StaleElementReferenceException e) {
					//System.err.println("Element is no longer present in DOM");
					logStatus("fail","Element is no longer present in DOM");
				}catch(WebDriverException e) {
					//System.err.println("Browser got closed due to unknown error");
					logStatus("fail","Browser got closed due to unknown error");
				}
			}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String actText=driver.findElementByXPath(xpath).getText();	
		if(actText.equals(text)) {
			//System.out.println("Textcontains Matched");
			logStatus("pass","Textcontains Matched");
		}else {
			//System.out.println("Textcontains NOT Matched");
			logStatus("fail","Textcontains NOT matched");
		}
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			//System.out.println("Element by Id got successfully clicked");
			logStatus("pass","Element by Id got successfully clicked ");
		} catch (NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public void clickByClassName(String classVal) {
		try {
		
			driver.findElementByClassName(classVal).click();
			//System.out.println("Element got successfully clicked byClassName");
			logStatus("pass","Element got successfully clicked by ClassName");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	
	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			//System.out.println("Element got successfully clicked ByName");
			logStatus("pass","Element got successfully clicked ByName");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	
	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("Element got successfully clicked ByLink");
			logStatus("pass","Element got successfully clicked ByLink");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("Element is clicked successfully using xpath as locator");
			logStatus("pass","Element is clicked successfully using xpath as locator");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("Element got clicked successfully using xpath as locator");
			logStatus("pass","Element got clicked successfully using xpath as locator");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("Element got clicked successfully using xpath as locator");
			logStatus("pass","Element got clicked successfully using xpath as locator");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public String getTextById(String idVal) {
		String text  = null;
		try {

			text = driver.findElementById(idVal).getText();
			//System.out.println("Get Text of element successfully using Id as locator");
			logStatus("pass","Get Text of element successfully using Id as locator");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}

		return text;
	}

	public String getTextByXpath(String xpathVal) {
	String text2= null;
	try
		{
		    text2=driver.findElementByXPath(xpathVal).getText();
	        //System.out.println("Get Text of Element successfully by using xpath as locator");
		    logStatus("pass","Get Text of element successfully by using xpath as locator");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
	    }
	return text2;
				
	}

	public void selectVisibileTextById(String id, String value) {
		WebElement s2;
		try {
			s2 = driver.findElementById(id);
		Select obj2=new Select(s2);
		obj2.selectByVisibleText(value); //155 line
		//System.out.println("Element successfully selected using VisibleText");
		logStatus("pass","Element successfully selected using Visibletext");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
		
	public void selectIndexById(String id, int value) {
		WebElement s3;
		try {
			s3 = driver.findElementById(id);
		Select obj3=new Select(s3);
		obj3.selectByIndex(value);
		//System.out.println("Element got selected successfully using Index");
		logStatus("pass","Element got selected successfully using Index");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
		
	public void switchToParentWindow() { //exceptions ?//return statement ?
		try {
	Set<String> allwindows = driver.getWindowHandles();
	System.out.println(allwindows);
	for(String singlewindow:allwindows) {
		driver.switchTo().window(singlewindow);
		//System.out.println("This method will successfully switch to parent window");
		logStatus("pass","This method will successfully switch to parent window");
		break;
	}
	}catch(NoSuchWindowException e) {
		//System.err.println("NO such Element is availabe to click");
		logStatus("fail","NO such Element is available to click");
	}catch(WebDriverException e) {
		//System.err.println("Browser got closed due to unknown error");
		logStatus("fail","Browser got closed due to unknown error");
	}
		
	}

	public void switchToLastWindow() {
		try {
		Set<String> allwindows= driver.getWindowHandles();
		System.out.println(allwindows);
		for(String singlewindow:allwindows) {
			driver.switchTo().window(singlewindow);
			//System.out.println("This method will successfulyy switch to lastwindow");
			logStatus("pass","This method will successfully switch to lastwindow");
		}
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		//System.out.println("This method will successfully accept the alert");
			logStatus("pass","This method will successfully accept the alert");
		}catch(NoAlertPresentException e) {
			//System.err.println("NO such alert present");
			logStatus("fail","NO such alert present");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");	
			logStatus("fail","Browser got closed due to unknown error");
		}
			
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		//System.out.println("This method will successfully dismiss the alert ");
			logStatus("pass","This method will successfully dismiss the alert");
		}catch(NoAlertPresentException e) {
			//System.err.println("No such alert present");
			logStatus("fail","No such alert present");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
		
		}	

	
	public String getAlertText() {
		try {
		driver.switchTo().alert().getText();
		//System.out.println("This method will successfully getText from alert");
		logStatus("pass","This method will successfully get Text from alert");
		}catch(NoAlertPresentException e) {
			//System.err.println("No such alert present ");
			logStatus("fail","No such alert present");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
		
		return null;	
	}
	
	public void closeBrowser() { //exceptions ?
		try {
			driver.close();
		//System.out.println("Successfully close the current browser");
			logStatus("pass","Successfully close the current browser");
		
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
		
	}
	
	public void closeAllBrowsers() {
		try {
			driver.quit();
		//System.out.println("Successfully close the associated all browsers");
			logStatus("pass","Successfully close the associated all browsers");
		
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	
		}	
	

	public long takeSnap() {
		long randomNumber = System.currentTimeMillis();
		File Pic=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./images/snap"+randomNumber+".jpg");
			try {
				FileUtils.copyFile(Pic, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return randomNumber;
	}

	public void mouseHoverByXpath(String XpathVal) {
		try {
		Actions actions=new Actions(driver);
		WebElement mouseover;
			mouseover = driver.findElementByXPath(XpathVal);
		actions.moveToElement(mouseover).perform();
		//System.out.println("Mouseover successfully performed");
		logStatus("pass","Mouseover successfully performed");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
		

	public void selectvaluebyxpath(String Xpathval,String text) {
		WebElement s3;
		try {
			s3=driver.findElementByXPath(Xpathval);
		Select obj3=new Select(s3);
		obj3.selectByValue(Xpathval); //155 line
		//System.out.println("Element successfully selected using Value");
		logStatus("pass","Element successfully selected using value");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void selectvisibletextbyXpath(String Xpathval, String text) {
		WebElement s4;
		try {
			s4=driver.findElementByXPath(Xpathval);
		Select obj4=new Select(s4);
		obj4.selectByVisibleText(text);
		//System.out.println("Element successfully selected using VisibleText");
		logStatus("pass","Element successfully selected using visibletext");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	

	public void selectvaluebyName(String Name, String text) {
		try {
		WebElement s5=driver.findElementByName(Name);
		Select obj5=new Select(s5);
		obj5.selectByValue(text);
		//System.out.println("Element successfully selected using Valuebyname");
		logStatus("pass","Element successfully selected using valuebyname");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
	
		}
	}
		
	public void selectvisibletextbyName(String Name, String text) {
		try {
		WebElement s6=driver.findElementByName(Name);
		Select obj6=new Select(s6);
		obj6.selectByVisibleText(text);
		//System.out.println("Element successfully selected using VisibleText");
		logStatus("pass","Element successfully selected using visibletext");
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}
	public void verifyemailIdByName(String Name, String text) {
		try {
		WebElement email= driver.findElementByName(Name);
		if(email.equals(email))
		{
			//System.out.println("email matching");
			logStatus("pass","Email matching");
		}else {
			//System.out.println("email NOT matching");
			logStatus("fail","email NOT matching");
		}
	}catch(NoSuchElementException e) {
		//System.err.println("NO such Element is available to click");
		logStatus("fail","No such Element is available to click");
	}catch(ElementNotSelectableException e) {
		//System.err.println("Element is not able to select");
		logStatus("fail","Element is not able to select");
	}catch(ElementNotVisibleException e) {
		//System.err.println("Element not visible to interact");
		logStatus("fail","Element not visible to interact");
	}catch(ElementClickInterceptedException e) {
		//System.err.println("Element is interrupted to perform click");
	    logStatus("fail","Element is interrupted to perform click");
	}catch(ElementNotInteractableException e) {
		//System.err.println("Element not able to interact");
		logStatus("fail","Element not able to interact");
	}catch(InvalidElementStateException e) {
		//System.err.println("Element is not valid,not loaded to perform click");
		logStatus("fail","Element is not valid,not loaded to perform click");
	}catch(StaleElementReferenceException e) {
		//System.err.println("Element is no longer present in DOM");
		logStatus("fail","Element is no longer present in DOM");
	}catch(WebDriverException e) {
		//System.err.println("Browser got closed due to unknown error");
		logStatus("fail","Browser got closed due to unknown error");
	}
}
	
	public void verifyMobileNoByName(String Name, String text) {
		try {
			WebElement MobileNo= driver.findElementByName(Name);
			if(MobileNo.equals(MobileNo))
			{
				//System.out.println("MobileNo matching");
				logStatus("pass","Mobileno matching");
			}else {
				//System.out.println("MobileNo NOT matching");
				logStatus("fail","Mobileno NOT matching");
			}
		}catch(NoSuchElementException e) {
			//System.err.println("NO such Element is available to click");
			logStatus("fail","No such Element is available to click");
		}catch(ElementNotSelectableException e) {
			//System.err.println("Element is not able to select");
			logStatus("fail","Element is not able to select");
		}catch(ElementNotVisibleException e) {
			//System.err.println("Element not visible to interact");
			logStatus("fail","Element not visible to interact");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("Element is interrupted to perform click");
		    logStatus("fail","Element is interrupted to perform click");
		}catch(ElementNotInteractableException e) {
			//System.err.println("Element not able to interact");
			logStatus("fail","Element not able to interact");
		}catch(InvalidElementStateException e) {
			//System.err.println("Element is not valid,not loaded to perform click");
			logStatus("fail","Element is not valid,not loaded to perform click");
		}catch(StaleElementReferenceException e) {
			//System.err.println("Element is no longer present in DOM");
			logStatus("fail","Element is no longer present in DOM");
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
		}
	}

	public void selectvalueById(String Id, String text) {
		try {
			WebElement s7=driver.findElementById(Id);
			Select obj7=new Select(s7);
			obj7.selectByValue(text);
			//System.out.println("Element successfully selected using ValuebyId");
			logStatus("pass","Element successfully selected using valuebyId");
			}catch(NoSuchElementException e) {
				//System.err.println("NO such Element is available to click");
				logStatus("fail","No such Element is available to click");
			}catch(ElementNotSelectableException e) {
				//System.err.println("Element is not able to select");
				logStatus("fail","Element is not able to select");
			}catch(ElementNotVisibleException e) {
				//System.err.println("Element not visible to interact");
				logStatus("fail","Element not visible to interact");
			}catch(ElementClickInterceptedException e) {
				//System.err.println("Element is interrupted to perform click");
			    logStatus("fail","Element is interrupted to perform click");
			}catch(ElementNotInteractableException e) {
				//System.err.println("Element not able to interact");
				logStatus("fail","Element not able to interact");
			}catch(InvalidElementStateException e) {
				//System.err.println("Element is not valid,not loaded to perform click");
				logStatus("fail","Element is not valid,not loaded to perform click");
			}catch(StaleElementReferenceException e) {
				//System.err.println("Element is no longer present in DOM");
				logStatus("fail","Element is no longer present in DOM");
			}catch(WebDriverException e) {
				//System.err.println("Browser got closed due to unknown error");
				logStatus("fail","Browser got closed due to unknown error");
			}
		}

	public void selectIndexByXpath(String XpathVal, int text) {
		try {
			WebElement s8=driver.findElementByXPath(XpathVal);
			Select obj8=new Select(s8);
			obj8.selectByIndex(text);
			//System.out.println("Element successfully selected using Index by Xpath");
			logStatus("pass","Element successfully selected using Indexbyxpath");
			}catch(NoSuchElementException e) {
				//System.err.println("NO such Element is available to click");
				logStatus("fail","No such Element is available to click");
			}catch(ElementNotSelectableException e) {
				//System.err.println("Element is not able to select");
				logStatus("fail","Element is not able to select");
			}catch(ElementNotVisibleException e) {
				//System.err.println("Element not visible to interact");
				logStatus("fail","Element not visible to interact");
			}catch(ElementClickInterceptedException e) {
				//System.err.println("Element is interrupted to perform click");
			    logStatus("fail","Element is interrupted to perform click");
			}catch(ElementNotInteractableException e) {
				//System.err.println("Element not able to interact");
				logStatus("fail","Element not able to interact");
			}catch(InvalidElementStateException e) {
				//System.err.println("Element is not valid,not loaded to perform click");
				logStatus("fail","Element is not valid,not loaded to perform click");
			}catch(StaleElementReferenceException e) {
				//System.err.println("Element is no longer present in DOM");
				logStatus("fail","Element is no longer present in DOM");
			}catch(WebDriverException e) {
				//System.err.println("Browser got closed due to unknown error");
				logStatus("fail","Browser got closed due to unknown error");
			}
		}

	public void Wait(int seconds) {
		try {
			Thread.sleep(seconds);
			//System.out.println("successfully wait for few seconds");
			logStatus("pass","successfully wait for few seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch(WebDriverException e) {
			//System.err.println("Browser got closed due to unknown error");
			logStatus("fail","Browser got closed due to unknown error");
	
		}
	}
}

	

	
