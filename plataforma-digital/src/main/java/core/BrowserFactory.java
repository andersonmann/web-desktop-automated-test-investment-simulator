/**
 * 
 */
package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author anderson.mann
 *
 */

public class BrowserFactory {
	protected static WebDriver driver;
	private static final String url = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";
	
	/**
	 * @param browser
	 */
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		try {
			driver.get(url);
		} catch (TimeoutException e) {
			System.out.println("Page: " + url + " did not load within 10 seconds!");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}