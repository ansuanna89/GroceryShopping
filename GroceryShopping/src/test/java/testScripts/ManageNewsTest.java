package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
	
	@Test(priority = 1, description = "Validate whether the user is able to create new News")
	public void verifyNewsCreation() throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		HomePage homePage = new HomePage(driver);
		homePage.clickManageNewsMoreInfoSection();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickNewBtnForNewsCreation();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.enterTextInNewsInputField(newsInfo);
		newsPage.clickSaveBtn();
		boolean successNews = newsPage.isNewsCreationSuccessAlertDisplayed();
		Assert.assertTrue(successNews, "Unable to create new News, News Success Message is not Displayed!!");
		String actualSuccessMsg=newsPage.validateNewsCreationSuccessMessage();
		//System.out.println(actualSuccessMsg);
		String expected ="News Created Successfully";
		boolean isSuccessMsgAvailble = actualSuccessMsg.contains(expected);
		//System.out.println(isSuccessMsgAvailble);
		Assert.assertTrue(isSuccessMsgAvailble, "The message 'News Created Successfully' is not displayed ");
		
	}
	
	@Test(priority = 2, description = "Validate whether the user is able to search News")
	public void verifyNewsSearchInManageNewsList()throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSignInBtn();
		HomePage homePage = new HomePage(driver);
		homePage.clickManageNewsMoreInfoSection();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickSearchBtn();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.enterSeacrhTextOnSearchTextBox(newsInfo);
		newsPage.clickSearchBtnInManageNewsSearchSection();
		String actual = newsPage.getDataFromSearchRsultandValidate();
		Assert.assertEquals(actual, newsInfo, "Search Results are not matching!!!");
	}

}
