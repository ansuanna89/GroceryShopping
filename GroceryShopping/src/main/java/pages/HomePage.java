package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']/img[contains(@src,'admin')]")
	WebElement adminProfile;
	@FindBy(xpath = "//a[contains(@href, 'logout') and @class='dropdown-item']")
	WebElement logOutBtn;
	@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(text(), 'More info')]")
	WebElement adminUserMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'list-news') and text()='More info ']")
	WebElement manageNewsMoreInfo;

	public HomePage clickProfileIcon() {
		adminProfile.click();
		return this;
	}

	public LoginPage clickLogOutBtn() {
		logOutBtn.click();
		return new LoginPage(driver);
		
	}

	public AdminUserPage clickAdminUsersMoreInfoSection() {
		adminUserMoreInfo.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage clickManageNewsMoreInfoSection() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
		
	}

}
