package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

	//page object  contains Constructor,locators and action methods

	//Constructor
	
 public HomePage(WebDriver driver)
	 
	 {
		super(driver);
		
	 }
	
     //locators
 
 
 @FindBy(xpath="//span[text()='My Account']") 
 WebElement myaccount;
 
 @FindBy(xpath="//a[text()='Register']") 
 WebElement clickregister;

 @FindBy(xpath="//a[text()='Login']") 
 WebElement clicklogin;
 
 //Methods
 
 public void clickMyaccount()
{
 	 
	 myaccount.click();
}


 public void clickRegister()
{
 	 
	 clickregister.click();
}
 
 public void clickloginpage()
{
 	 
	 clicklogin.click();
}

}
