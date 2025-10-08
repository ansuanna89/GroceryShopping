package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	@Test(priority = 1,description = "User is trying to login with valid credentials",groups = {"smoke"})
	public void verifyLoginWithValidCredentials() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		boolean dashBoardDisplay = loginPage.isDasboardDisplayed();
		Assert.assertTrue(dashBoardDisplay, "User was unable to login with valid credentials");

	}

	@Test(priority = 2)
	public void verifyLoginWithValidUserNameInvalidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		String expected = "7rmart supermarket";
		String actual = loginPage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, "User was able to login with Invalid credentials");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidUserNameValidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
	}

	@Test(priority = 4,groups = {"smoke"})
	public void verifyLoginWithInvalidUserNameInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
	}

}
