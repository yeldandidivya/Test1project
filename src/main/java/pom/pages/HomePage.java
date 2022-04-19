
package pom.pages;

import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class HomePage  extends GenericWrappers{
	
	public HomePage selectValueByXpath(String Xpath,String value) {
		selectValueByXpath("//*[@id=\"searchDropdownBox\"]",value);
		return this;
	
	}

	public HomePage enterByXpath(String xpathValue,String data) {
		enterByXpath("//*[@id=\"twotabsearchtextbox\"]", data);
        return this;	
	}
	public HomePage clickByXpath(String xpath) {
		clickByXpath("//*[@id=\"nav-search-submit-button\"]");
		return  this;
	}
	public HomePage verifyUrl(String url) {
		
		return this;
		
	}
}
