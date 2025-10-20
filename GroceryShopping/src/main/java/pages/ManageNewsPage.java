package pages;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

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

	public ManageNewsPage clickNewBtnForNewsCreation() {
		newBtn.click();
		return this;
	}

	public ManageNewsPage enterTextInNewsInputField(String news) {
		newsTextArea.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveBtn() {
		saveBtn.click();
		return this;
	}

	public boolean isNewsCreationSuccessAlertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newsCreatedSuccessAlert));
		return newsCreatedSuccessAlert.isDisplayed();
	}

	public String validateNewsCreationSuccessMessage() {
		return newsCreatedSuccessAlert.getText();
	}

	public ManageNewsPage clickSearchBtn() {
		searchBtnLink.click();
		return this;
	}

	public ManageNewsPage enterSeacrhTextOnSearchTextBox(String news) {
		searchTextInputField.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSearchBtnInManageNewsSearchSection() {
		searchBtn.click();
		return this;
	}

	public String getDataFromSearchRsultandValidate() {

		final int MAX_ATTEMPTS = 3;
		for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
			try {
				
				wait.waitUntilVisibilityOfElement(driver, searchResultTableRow);
				return searchResultTableRow.getText();
				
			} catch (StaleElementReferenceException e) {
				// Log this and continue the loop to retry
				System.out.println("Stale element caught. Retrying... Attempt " + (attempt + 1));
				// The next loop iteration will implicitly trigger a re-find via the
				// PageFactory/proxy
			}
		}
		// If we exit the loop, all attempts failed
		throw new RuntimeException(
				"Failed to get data after " + MAX_ATTEMPTS + " attempts due to StaleElementReferenceException.");
	}

}
