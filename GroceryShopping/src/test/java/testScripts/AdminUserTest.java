package testScripts;

import java.io.IOException;
import java.nio.channels.AcceptPendingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends TestNGBase {

	HomePage homePage;
	AdminUserPage adminUserPage;

	@Test(priority = 1, description = "Admin user is trying to create new users")
	public void verifyNewUserCreation() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage = loginPage.clickSignInBtn();

		adminUserPage = homePage.clickAdminUsersMoreInfoSection();

		adminUserPage.clickNewButton();

		RandomDataUtility random = new RandomDataUtility();
		String newUser_Name = random.createRandomUserName();
		String newUser_Password = random.createRandomPassword();
		String newUser_Type = ExcelUtility.getStringData(0, 2, "AdminUserPage");
		adminUserPage.enterUserNameForNewUser(newUser_Name).enterPasswordForNewUser(newUser_Password).chooseUserType(newUser_Type).clickSaveBtn();
		
		boolean usercreatedAlert = adminUserPage.isUserCreationSuccessAlertDisplayed();
		Assert.assertTrue(usercreatedAlert, newUser_Name + Constant.UnableToCreateUser);

		String expected = "User Created Successfully";
		String actual = adminUserPage.validateUserCreationSuccessMessage();
		System.out.println(actual.contains(expected));
		Assert.assertTrue(actual.contains(expected), Constant.UnableToCreateUser);

	}

	@Test(priority = 2, description = "Admin user is trying to search newly created user")
	public void verifySearchAdminUsers() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginPage.clickSignInBtn();
		adminUserPage= homePage.clickAdminUsersMoreInfoSection();
		adminUserPage.clickSearchBtn();
		String userToSearch = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		String userTypeToSearch = ExcelUtility.getStringData(0, 2, "AdminUserPage");
		adminUserPage.enterUsernameInSearchUsernameField(userToSearch).selectUserTypeForSearch(userTypeToSearch).clickBtnSearchAdminUser();
		String actual = adminUserPage.isUserListed();
		Assert.assertEquals(actual, userToSearch, Constant.SearchedUserNotAvailable);

	}

	@Test(priority = 3, description = "Admin user is doing refresh")
	public void validateResetOption() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=	loginPage.clickSignInBtn();
		
		adminUserPage=homePage.clickAdminUsersMoreInfoSection();
		
		adminUserPage.clickOnResetBtn().clickNewButton().clickResetButtn();
		boolean userInfoHeaderOnReset = adminUserPage.isAdminUserInfoHeaderDisplayed();
		Assert.assertFalse(userInfoHeaderOnReset, Constant.ResetNotHappened);

	}

}
