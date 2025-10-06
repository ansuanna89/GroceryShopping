package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New']")
	WebElement newBtn;
	@FindBy(id = "username")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(id = "user_type")
	WebElement userType;
	@FindBy(name = "Create")
	WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	WebElement userCreationSuccessMsg;
	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchBtn;
	@FindBy(id = "un")
	WebElement userNameSearch;
	@FindBy(id = "ut")
	WebElement userTypeSearch;
	@FindBy(name = "Search")
	WebElement searchAdminUser;
	@FindBy(xpath = "//tr[1]/td[1]")
	WebElement searchResultTable;
	@FindBy(xpath = "//a[text()=' Reset']")
	WebElement resetBtnlink;
	
	@FindBy(xpath="//button[@name='Create']/following::a[text()='Reset']") WebElement resetBtn;
	@FindBy(xpath="//h3[text()='Admin Users Informations']") WebElement adminUserInfoHeading;

	/*
	 * * //div[contains(@class, 'alert-success')]/text()[contains(., 'User Created
	 * Successfully')]
	 */

	public void clickNewButton() {
		newBtn.click();
	}

	public void enterUserNameForNewUser(String name) {
		userNameField.clear();
		userNameField.sendKeys(name);
	}

	public void enterPasswordForNewUser(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void chooseUserType(String uType) {
		Select sel = new Select(userType);
		sel.selectByVisibleText(uType);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public boolean isUserCreationSuccessAlertDisplayed() {

		return userCreationSuccessMsg.isDisplayed();
	}

	public String validateUserCreationSuccessMessage() {

		return userCreationSuccessMsg.getText();

	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void enterUsernameInSearchUsernameField(String name) {
		userNameSearch.sendKeys(name);

	}

	public void selectUserTypeForSearch(String uType) {

		Select sel = new Select(userTypeSearch);
		sel.selectByVisibleText(uType);
	}

	public void clickBtnSearchAdminUser() {
		searchAdminUser.click();
	}

	public String isUserListed() {
		return searchResultTable.getText();
	}

	public void clickOnResetBtn() {
		resetBtnlink.click();
	}
	
	public void clickResetButtn() {
		resetBtn.click();
	}
	
	public boolean isAdminUserInfoHeaderDisplayed() {
		return adminUserInfoHeading.isDisplayed();
	}
}
