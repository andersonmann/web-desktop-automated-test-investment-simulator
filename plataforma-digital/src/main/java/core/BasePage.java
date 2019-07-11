/**
 * 
 */
package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import util.ExtentTestManager;

/**
 * @author anderson.mann
 *
 */
public class BasePage extends BrowserFactory {
	protected ExtentTestManager log = new ExtentTestManager();

	/**
	 * This auxiliary method proved a smart wait for a element
	 * 
	 * @param By  Type of locator used for search (Ex: id, name, xpath,cssSelector)
	 * @param the locator identifier
	 */
	private void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(by));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Find an element and click
	 * 
	 * @param By  Type of locator used for search (Ex: id, name, xpath,cssSelector)
	 * @param the locator identifier
	 * @throws NoSuchElementException
	 */

	public void click(By by) throws NoSuchElementException {
		try {
			waitForElement(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/**
	 * @param text
	 */
	public void clickByText(String text) {
		click(By.xpath("//*[@text='" + text + "']"));
	}

	/**
	 * Find an element and perform writing in the field
	 * 
	 * 
	 * @param By     Type of locator used for search (Ex: id, name,
	 *               xpath,cssSelector)
	 * @param String Text to be written in the field
	 */
	public void write(By by, String text) {
		try {
			waitForElement(by);
			driver.findElement(by).sendKeys(text);
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/**
	 * Find an element and get the message
	 * 
	 * @param By  Type of locator used for search (Ex: id, name, xpath,cssSelector)
	 * @param the locator identifier
	 * @return the value of element
	 * @throws NoSuchElementException
	 */

	public String getValue(By by) throws NoSuchElementException {
		try {
			waitForElement(by);
			return driver.findElement(by).getText();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/**
	 * @param espara por N segundos
	 */
	public void stop(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return a URL do site
	 */
	public String currentURL() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
	}

	/**
	 * @param id
	 */
	public void enterFrame(String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * 
	 */
	public void exitFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 */
	public void switchTo(int value) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[value]);
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean existElement(By by) throws NoSuchElementException {
		try {
			waitForElement(by);
			List<WebElement> elementos = driver.findElements(by);
			return elementos.size() > 0;
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}
	
	public void scrollTo() {
		 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	}

}