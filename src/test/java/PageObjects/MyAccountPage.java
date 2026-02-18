package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// page object contains Constructor,locators and action methods

	// Constructor

	public MyAccountPage(WebDriver driver)

	{
		super(driver);

	}

	// locators

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgheading;

	// Methods


	public boolean isMyaccountpageExists() {
		try {

			return (msgheading.isDisplayed());
		}

		catch (Exception e) {

			return false;
		}
	}

}
