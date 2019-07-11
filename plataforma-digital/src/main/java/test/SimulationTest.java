/**
 * 
 */
package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import page.SimulationPage;

/**
 * @author anderson.mann
 *
 */
public class SimulationTest extends BaseTest {
	private SimulationPage simulation = new SimulationPage();
	private static final String ACTION_1 = "//a[@class='btn btnAmarelo btnRefazer']";
	public static final String PROFILE1 = "pessoa fisica";
	public static final String PROFILE2 = "pessoa juridica";

	public enum Profiles {
		PROFILE1, PROFILE2;
	}

	@DataProvider(name = "profile1-months")
	public static Object[][] pf1() {
		return new Object[][] { { PROFILE1, "500000", "10000", "36", "meses" } };
	}

	@DataProvider(name = "profile1-years")
	public static Object[][] pf2() {
		return new Object[][] { { PROFILE1, "500000", "10000", "2", "anos" } };
	}

	@DataProvider(name = "profile2-months")
	public static Object[][] pj1() {
		return new Object[][] { { PROFILE2, "500000", "10000", "36", "meses" } };
	}

	@DataProvider(name = "profile2-years")
	public static Object[][] pj2() {
		return new Object[][] { { PROFILE2, "500000", "10000", "2", "anos" } };
	}

	@Test(dataProvider = "profile1-months", priority = 0)
	public void validSimulationProfile1Months(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "profile1-years", priority = 1)
	public void validSimulationProfile1Years(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "profile2-months", priority = 2)
	public void validSimulationProfile2Months(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "profile2-years", priority = 3)
	public void validSimulationProfile2Years(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath(ACTION_1)));
	}

//	@Test
//	public void test() {
//		esperar(2000);
//		simulation.scrollToDown();
//		simulation.switchTo(0);
//		simulation.selectProfile("pessoa juridica");
//		simulation.write(By.id("valorAplicar"), "2222");
//		simulation.write(By.id("valorInvestir"), "99999");
//		simulation.write(By.id("tempo"), "10");
//		simulation.selectTimeType("Meses");
//		simulation.clickSimuteButton();
//		esperar(3000);
//	}

}
