package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	/***********Basic Actions*/
	
	public void clickElement(WebElement element) {
		
		element.click();
	}
	
	public void typeText(WebElement element,String textToEnter) {
		element.clear();
		element.sendKeys(textToEnter);
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	/*----------------------------------------------------Actions-Mouse Events------------------------------------------------------------*/

	public void rightClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();

	}

	public void mouseOver(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void dragAndDropAnElement(WebDriver driver, WebElement dragElement, WebElement dropElement) {

		Actions action = new Actions(driver);
		action.dragAndDrop(dragElement, dropElement).build().perform();

	}

	/*----------------------------------------------------Check Box-------------------------------------------------------------*/
	public boolean isCheckboxSelected(WebElement checkbox) {

		return checkbox.isSelected();
	}

	public void selectCheckBox(WebElement checkbox) {

		if (!isCheckboxSelected(checkbox)) {
			checkbox.click();

		}
	}

	public void deselectCheckbox(WebElement checkbox) {
		if (isCheckboxSelected(checkbox)) {
			checkbox.click();

		}
	}

	/*----------------------------------------------------Radio Button-------------------------------------------------------------*/
	public boolean isRadioButtonSelected(WebElement radioButton) {
		return radioButton.isSelected();
	}

	public void selectRadioButton(WebElement radioButton) {
		if (!isRadioButtonSelected(radioButton)) {
			radioButton.click();

		}
	}

	/*----------------------------------------------------Alert-------------------------------------------------------------*/
	public void alertAcceptConfirmation(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public void alertDismissConfirmation(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.dismiss();

	}

	public void alertPromptAcceptConfirmation(WebDriver driver, String promptText) {

		Alert al = driver.switchTo().alert();
		al.sendKeys(promptText);
		al.accept();

	}

	public void clickElementJavaScript(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver; // casting the control of driver
		js.executeScript("arguments[0].click();", element); // to execute an action and
															// arguments[0].click()-->predefined method if normal
															// click() is not worked

	}

	/*------------------------------------------------Scroll----------------------------------------------*/
	public void scrollWindow(WebDriver driver, int x_axis, int y_axis) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,350)", "");
		String script = String.format("window.scrollBy(%d, %d);", x_axis, y_axis);
		js.executeScript(script);
	}

	public void scrollToElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "arguments[0].scrollIntoView(true);"; // The argument[0] refers to the WebElement passed as the
																// second argument to executeScript
		js.executeScript(script, element);
	}

	/*----------------------------------------------------Switch Window-------------------------------------------------------------*/
	public void swithToWindow(WebDriver driver, String parentWindowID) {

		Set<String> handleIds = driver.getWindowHandles();
		Iterator<String> it = handleIds.iterator();
		while (it.hasNext()) {
			String currentId = it.next();
			if (!currentId.equals(parentWindowID)) {
				driver.switchTo().window(currentId);
			}
		}
	}

	/*----------------------------------------------------Switch Frame-------------------------------------------------------------*/
	public void switchToFrame(WebDriver driver, WebElement frameElement) {

		driver.switchTo().frame(frameElement);
	}

	/*----------------------------------------------------Keyboard Events-------------------------------------------------------------*/
	public void openNewTab() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}

	public void OpenNewWindow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_N);
	}

}
