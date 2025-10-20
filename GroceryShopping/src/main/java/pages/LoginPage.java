package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	PageUtility pageutl = new PageUtility();
	WaitUtility wait = new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement userNameTxt;
	@FindBy(name = "password")
	WebElement passwordTxt;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInBtn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashBoard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginTitle;

	public LoginPage enterUserNameinUserNameField(String usernameValue) {
		userNameTxt.sendKeys(usernameValue);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		passwordTxt.sendKeys(passwordValue);
		return this;

	}

	public HomePage clickSignInBtn() {

		wait.waitUntilElementToBeClickable(driver, signInBtn);
		signInBtn.click();
		return new HomePage(driver);

	}

	public boolean isDasboardDisplayed() {

		return dashBoard.isDisplayed();

	}

	public String isTitleDisplayed() {

		final int MAX_ATTEMPTS = 3;
		for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
			try {
				wait.waitUntilVisibilityOfElement(driver, loginTitle);
				return loginTitle.getText();
			} 
			catch (StaleElementReferenceException e) {
				System.out.println("Stale element caught. Retrying... Attempt " + (attempt + 1));
			}
		}
		throw new RuntimeException(
				"Failed to get data after " + MAX_ATTEMPTS + " attempts due to StaleElementReferenceException.");

	}
}
