package testScripts;

import java.io.IOException;
import java.nio.channels.AcceptPendingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends TestNGBase {

	@Test
	public void verifyNewUserCreation() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		HomePage homePage = new HomePage(driver);
		homePage.clickAdminUsersMoreInfoSection();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickNewButton();

		RandomDataUtility random = new RandomDataUtility();		
		String newUser_Name = random.createRandomUserName();
		String newUser_Password = random.createRandomPassword();
		String newUser_Type = ExcelUtility.getStringData(0, 2, "AdminUserPage");
		adminUserPage.enterUserNameForNewUser(newUser_Name);
		adminUserPage.enterPasswordForNewUser(newUser_Password);
		adminUserPage.chooseUserType(newUser_Type);
		adminUserPage.clickSaveBtn();
		boolean usercreatedAlert = adminUserPage.isUserCreationSuccessAlertDisplayed();
		Assert.assertTrue(usercreatedAlert, newUser_Name + ": Unable to create New User!!");

		
		 String expected = "User Created Successfully"; 
		 String actual = adminUserPage.validateUserCreationSuccessMessage();
		 System.out.println(actual.contains(expected));
		 Assert.assertTrue(actual.contains(expected), "Unable to create new user");
		 
		 

	}

	@Test
	public void verifySearchAdminUsers() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		HomePage homePage = new HomePage(driver);
		homePage.clickAdminUsersMoreInfoSection();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickSearchBtn();
		String userToSearch = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		String userTypeToSearch = ExcelUtility.getStringData(0, 2, "AdminUserPage");
		adminUserPage.enterUsernameInSearchUsernameField(userToSearch);
		adminUserPage.selectUserTypeForSearch(userTypeToSearch);
		adminUserPage.clickBtnSearchAdminUser();
		String actual = adminUserPage.isUserListed();
		Assert.assertEquals(actual, userToSearch, "Searched User is not available in the System!!");

	}
	
	@Test
	public void validateResetOption() throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		HomePage homePage = new HomePage(driver);
		homePage.clickAdminUsersMoreInfoSection();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickOnResetBtn();
		adminUserPage.clickNewButton();
		adminUserPage.clickResetButtn();
		boolean userInfoHeaderOnReset = adminUserPage.isAdminUserInfoHeaderDisplayed();
		Assert.assertFalse(userInfoHeaderOnReset, "Admin User Information header is still displayed, Reset is not happening properly");
		
	}

}
