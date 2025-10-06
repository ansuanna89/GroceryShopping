package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

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

	public void enterUserNameinUserNameField(String usernameValue) {
		userNameTxt.sendKeys(usernameValue);
	}

	public void enterPasswordOnPasswordField(String passwordValue) {
		passwordTxt.sendKeys(passwordValue);
	}

	public void clickSignInBtn() {
		signInBtn.click();
	}

	public boolean isDasboardDisplayed() {

		return dashBoard.isDisplayed();
	}

	public String isTitleDisplayed() {
		return loginTitle.getText();

	}
}
