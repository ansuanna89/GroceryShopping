package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {

	HomePage homePage;
	@Test(priority = 1 , description = "Admin user is trying tologout from the application")
	public void verifyLogout() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage= loginPage.clickSignInBtn();

		homePage.clickProfileIcon();
		loginPage= homePage.clickLogOutBtn();
	}

}
