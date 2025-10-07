package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'news') and contains(text(),'New')]")
	WebElement newBtn;
	@FindBy(id = "news")
	WebElement newsTextArea;
	@FindBy(name = "create")
	WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement newsCreatedSuccessAlert;
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement searchBtnLink;
	@FindBy(name = "un")
	WebElement searchTextInputField;
	@FindBy(name = "Search")
	WebElement searchBtn;
	@FindBy(xpath = "//tr[1]/td[1]")
	WebElement searchResultTableRow;

	public void clickNewBtnForNewsCreation() {
		newBtn.click();
	}

	public void enterTextInNewsInputField(String news) {
		newsTextArea.sendKeys(news);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public boolean isNewsCreationSuccessAlertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newsCreatedSuccessAlert));
		return newsCreatedSuccessAlert.isDisplayed();
	}

	public String validateNewsCreationSuccessMessage() {
		return newsCreatedSuccessAlert.getText();
	}

	public void clickSearchBtn() {
		searchBtnLink.click();
	}

	public void enterSeacrhTextOnSearchTextBox(String news) {
		searchTextInputField.sendKeys(news);
	}

	public void clickSearchBtnInManageNewsSearchSection() {
		searchBtn.click();
	}

	public String getDataFromSearchRsultandValidate() {
		return searchResultTableRow.getText();
	}

}
