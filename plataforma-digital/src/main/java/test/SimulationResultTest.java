   /**
 * 
 */
package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import page.SimulationPage;

/**
 * @author anderson.mann
 *
 */
public class SimulationResultTest extends BaseTest {
	private SimulationPage simulation = new SimulationPage();
	private static final String ACTION_1 = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/strong[1]";
	public static final String PROFILE1 = "pessoa fisica";
	public static final String PROFILE2 = "pessoa juridica";
	public static final String TIME1 = "meses";
	public static final String TIME2 = "anos";

	public enum Profiles {
		PROFILE1, PROFILE2;
	}

	public enum TimeType {
		TIME1, TIME2;
	}

	@DataProvider(name = "months")
	public static Object[][] months() {
		return new Object[][] { { PROFILE1, "500000", "10000", "36", TIME1 } };
	}

	@DataProvider(name = "years")
	public static Object[][] years() {
		return new Object[][] { { PROFILE2, "500000", "10000", "2", TIME2 } };
	}

	@Test(dataProvider = "months", priority = 0)
	public void validSimulationMonths(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		simulation.exitFrame();
		assertEquals("36 meses", simulation.getValue(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "years", priority = 1)
	public void validSimulationYears(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		simulation.exitFrame();
		assertEquals("24 meses", simulation.getValue(By.xpath(ACTION_1)));
	}
}
