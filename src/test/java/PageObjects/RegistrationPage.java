package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver)
	 
	 {
		super(driver);
		
	 }
	
     //locators
 
 @FindBy(xpath="//a[text()='Female']")
 WebElement gender;
 
 @FindBy(xpath="//input[@id='input-firstname']")
 WebElement setfirstname;
 
 @FindBy(xpath="//input[@id='input-lastname']")
 WebElement setlastname;
 
 @FindBy(xpath="//input[@id='input-email']")
 WebElement setemail;
 
 @FindBy(xpath="//input[@id='input-telephone']")
 WebElement settelephone;
 
 @FindBy(xpath="//input[@id='input-password']")
 WebElement setpassword;
 
 @FindBy(xpath="//input[@id='input-confirm']")
 WebElement setconfirmpwd;
 
 @FindBy(xpath="//label[text()='Yes']")
 WebElement setNewsletter;
 
 @FindBy(xpath="//input[@name='agree']")
 WebElement setagree;
 
 @FindBy(xpath="//input[@value='Continue']")
 WebElement ClickContinue;

 @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
 WebElement Confirmation;
 
 //Methods
 

 public void setFirstName(String fname)
{
 	setfirstname.sendKeys(fname);	 
}
 
 public void setlastName(String lname)
{ 	 
	 setlastname.sendKeys(lname);	
}
 
 public void setEmail(String mail)
{
	 setemail.sendKeys(mail);
 }
 public void setnumber(String phn)
{ 	 
	 settelephone.sendKeys(phn);
	
}
 public void setPassword(String pwd)
{ 	 
	 setpassword.sendKeys(pwd);
	
}
 public void setcnfPassword(String cnfpwd)
{ 	 
	 setconfirmpwd.sendKeys(cnfpwd);
	
}
 public void Newsletter()
{ 	 
	 setNewsletter.click();
		
}

 public void agree()
{ 	 
	 setagree.click();
	
}


  public String getConfirmation() { 
	  try {
  
  return(Confirmation.getText()); }
  
  catch(Exception e) { 
	  
	  return(e.getMessage());
  
  } 
	  }
 
 
 public void cfmcontinue()
 {
	 ClickContinue.click();
 
 
 }
 
  
 }
 
 
 
