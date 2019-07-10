package core;

/***
 * 
 * @author anderson.mann
 *
 */

//@Listeners({ ScreenshotUtility.class })

public class BaseTest extends BrowserFactory {

	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
