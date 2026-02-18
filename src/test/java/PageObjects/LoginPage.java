package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// page object contains Constructor,locators and action methods

	// Constructor

	public LoginPage(WebDriver driver)

	{
		super(driver);

	}

	// locators

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement setemail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement setpassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginaccount;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement accountverify;

	// Methods

	public void clickEmail(String mail) {

		setemail.sendKeys(mail);
	}

	public void clickpassword(String pass) {

		setpassword.sendKeys(pass);
	}

	public void clickloginpage() {

		loginaccount.click();
	}

	public String setlogin() {
		try {

			return (accountverify.getText());
		}

		catch (Exception e) {

			return (e.getMessage());
		}
	}

}
