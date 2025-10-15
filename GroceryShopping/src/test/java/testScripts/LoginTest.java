package testScripts;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	HomePage homePage;
	
	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void verifyLoginWithValidCredentials() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginPage.clickSignInBtn();
		boolean dashBoardDisplay = loginPage.isDasboardDisplayed();
		Assert.assertTrue(dashBoardDisplay, Constant.ValidCredentialError);

	}

	@Test(priority = 2, description = "User is trying to login with valid Username and Invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyLoginWithValidUserNameInvalidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(11, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickSignInBtn();
		String expected = "7rmart supermarket";
		String actual = loginPage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.InvalidPasswordError);
	}

	@Test(priority = 3, description = "User is trying to login with Invalid Username and Valid Password")
	public void verifyLoginWithInvalidUserNameValidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickSignInBtn();
		String expected = "7rmart supermarket";
		String actual = loginPage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.InvalidUserNameError);
		
	}

	@Test(priority = 4, description = "User is trying to login with Invalid credentials", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyLoginWithInvalidUserNameInvalidPassword(String usernameValue, String passwordValue)
			throws IOException {
		// String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickSignInBtn();
		
		String expected = "7rmart supermarket";
		String actual = loginPage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.InvalidCredentialError);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
