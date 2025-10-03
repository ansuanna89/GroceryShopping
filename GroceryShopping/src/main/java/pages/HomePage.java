package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']/img[contains(@src,'admin')]") WebElement adminProfile;
	@FindBy(xpath="//a[contains(@href, 'logout') and @class='dropdown-item']") WebElement logOutBtn;
	
	public void clickProfileIcon() {
		adminProfile.click();
	}
	
	public void clickLogOutBtn() {
		logOutBtn.click();
	}

}
