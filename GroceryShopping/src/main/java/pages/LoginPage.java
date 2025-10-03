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

	public void enterUserNameinUserNameField(String usernameValue) {
		userNameTxt.sendKeys(usernameValue);
	}

	public void enterPasswordOnPasswordField(String passwordValue) {
		passwordTxt.sendKeys(passwordValue);
	}

	public void clickSignInBtn() {
		signInBtn.click();
	}

}
