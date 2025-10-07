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

	public void clickProfileIcon() {
		adminProfile.click();
	}

	public void clickLogOutBtn() {
		logOutBtn.click();
	}

	public void clickAdminUsersMoreInfoSection() {
		adminUserMoreInfo.click();
	}

	public void clickManageNewsMoreInfoSection() {
		manageNewsMoreInfo.click();
	}

}
