package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	
	public void verify_accountRegistration() {
		try {

			logger.info("********* Starting TC001AccountRegistrationTest **********");
			HomePage hm = new HomePage(driver);

			hm.clickMyaccount();
			hm.clickRegister();

			logger.info("********* Starting RegistrationPage **********");
			RegistrationPage reg = new RegistrationPage(driver);

			reg.setFirstName("Mourvi");
			reg.setlastName("darshan");
			reg.setEmail("xasada@gmail.com");
			reg.setnumber("9874545674");
			reg.setPassword("Mourvi2023");
			reg.setcnfPassword("Mourvi2023");
			reg.agree();
			reg.Newsletter();
			reg.cfmcontinue();
			reg.getConfirmation();
			
			logger.info("********* completed with entering the details  **********");

			String confrmsg = reg.getConfirmation();
			Assert.assertEquals(confrmsg, "Your Account Has Been Created!");

		} catch (Exception e) 
		{
			
			Assert.fail();
		}

		logger.info("********* Successfully completed Registration  **********");

	}

}
