package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {

	@Test
	public void verifyLogout() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();

		HomePage homePage = new HomePage(driver);
		homePage.clickProfileIcon();
		homePage.clickLogOutBtn();
	}

}
