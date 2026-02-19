package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verify_Login() {
		
			logger.info("********* Starting TC002_LoginTest **********");

			logger.debug("**** Homepage started *****");
		
			HomePage hm = new HomePage(driver);
			hm.clickMyaccount();
			hm.clickloginpage();

			logger.debug("**** Login started *****");
			
			LoginPage lg = new LoginPage(driver);
			lg.clickEmail(p.getProperty("Email"));
			lg.clickpassword(p.getProperty("Password"));
			lg.clickloginpage();
			
			logger.debug("**** Myaccountpage started *****");
			
			MyAccountPage page = new MyAccountPage(driver);
			boolean targetpage = page.isMyaccountpageExists();
		
			Assert.assertEquals(targetpage, true,"Login failed");
			
		
			logger.info("********* Login completed  **********");

	

}
}
