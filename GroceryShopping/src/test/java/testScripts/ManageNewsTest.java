package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
	HomePage homePage;
	ManageNewsPage newsPage;
	
	@Test(priority = 1, description = "Validate whether the user is able to create new News")
	public void verifyNewsCreation() throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage =loginPage.clickSignInBtn();
		newsPage= homePage.clickManageNewsMoreInfoSection();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.clickNewBtnForNewsCreation().enterTextInNewsInputField(newsInfo).clickSaveBtn();
		boolean successNews = newsPage.isNewsCreationSuccessAlertDisplayed();
		Assert.assertTrue(successNews, Constant.NewsNotCreated);
		String actualSuccessMsg=newsPage.validateNewsCreationSuccessMessage();
		//System.out.println(actualSuccessMsg);
		String expected ="News Created Successfully";
		boolean isSuccessMsgAvailble = actualSuccessMsg.contains(expected);
		//System.out.println(isSuccessMsgAvailble);
		Assert.assertTrue(isSuccessMsgAvailble, Constant.NewsCreatedSuccessBannerNotDisplayed);
		
	}
	
	@Test(priority = 2, description = "Validate whether the user is able to search News")
	public void verifyNewsSearchInManageNewsList()throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameinUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage =loginPage.clickSignInBtn();
		newsPage= 	homePage.clickManageNewsMoreInfoSection();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.clickSearchBtn().enterSeacrhTextOnSearchTextBox(newsInfo).clickSearchBtnInManageNewsSearchSection();
		String actual = newsPage.getDataFromSearchRsultandValidate();
		Assert.assertEquals(actual, newsInfo, Constant.NewsSearchIsNotWorking);
	}

}
