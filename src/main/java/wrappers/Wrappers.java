package wrappers;

public interface Wrappers {
	
		/**
		 * This method will launch the given browser and maximise the browser and set the
		 * wait for 30 seconds and load the url
		 * @author Harish
		 * @param browser - The browser of the application to be launched
		 * @param url - The url with http or https
		 * @throws Exception 
		 * 
		 */
		public void invokeApp(String browser, String url);

		/**
		 * This method will enter the value to the text field using id attribute to locate
		 * 
		 * @param idValue - id of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Harish
		 * @return 
		 * @throws Exception 
		 */
		public void enterById(String idValue, String data);
		
		/**
		 * This method will enter the value to the text field using name attribute to locate
		 * 
		 * @param nameValue - name of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Harish
		 */
		public void enterByXpath(String xpathValue, String data);


		/**
		 * This method will verify the title of the browser 
		 * @param title - The expected title of the browser
		 * @author Harish
		 */
		public void verifyTitle(String title);
		
		/**
		 * This method will verify the given text
		 * @param id - The locator of the object in id
		 * @param text  - The text to be verified
		 * @author Harish
		 */
		
		public void verifyTextByXpath(String xpath, String text);
			
			/**
			 * This method will verify the given text with partial match
			 * @param xpath - The locator of the object in xpath
			 * @param text  - The text to be verified
			 * @author Harish
			 */
		public void clickByXpath(String xpathVal);
		
		/**
		 * This method will click the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element to be clicked
		 * @author Harish
		 */
		public String getTextByXpath(String xpathVal);

		/**
		 * This method will select the drop down visible text using id as locator
		 * @param id The id (locator) of the drop down element
		 * @param value The value to be selected (visibletext) from the dropdown 
		 * @author Harish
		 */
		public void acceptAlert();
		
		/**
		 * This method will accept the alert opened
		 * @author Harish
		 */
		public void dismissAlert();
		
		/**
		 * This method will dismiss the alert opened
		 * @author Harish
		 */
		public String getAlertText();
		
		/**
		 * This method will return the text of the alert
		 * @author Harish
		 */
		
		public long takeSnap();
			
		/**
		 * This method will take snapshot of the browser
		 * @author Harish
		 */
		public void closeBrowser();
		
		/**
		 * This method will close the active browser
		 * @author Harish
		 */
		
		public void Wait(int seconds);
		/**
		 * this method will wait for few seconds
		 */
		
		public void closeAllBrowsers();
		/**
		 * This method will close all the browsers
		 
		 */
		
		public void mouseHoverByXpath(String XpathVal);
		
		
		
		public void selectvaluebyxpath(String Xpathval,String text);
		
		public void selectvalueById(String Id,String text);
		
		public void selectvalueByName(String Name,String text);
		
		public void verifyurlByXpath(String XpathVal,String data);
		
		public void verifyemailidByXpath(String XpathVal,String text);
		
		
}

