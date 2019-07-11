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
	private static final String profile1 = "pessoa fisica";
	private static final String profile2 = "pessoa juridica";

	@DataProvider(name = "profile1-months")
	public static Object[][] pf1() {
		return new Object[][] { { profile1, "500000", "10000", "36", "meses" } };
	}

	@DataProvider(name = "profile1-years")
	public static Object[][] pf2() {
		return new Object[][] { { profile1, "500000", "10000", "2", "anos" } };
	}

	@DataProvider(name = "profile2-months")
	public static Object[][] pj1() {
		return new Object[][] { { profile2, "500000", "10000", "36", "meses" } };
	}

	@DataProvider(name = "profile2-years")
	public static Object[][] pj2() {
		return new Object[][] { { profile2, "500000", "10000", "2", "anos" } };
	}

	@Test(dataProvider = "profile1-months", priority = 0)
	public void validSimulationProfile1Months(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath("//a[@class='btn btnAmarelo btnRefazer']")));
	}

	@Test(dataProvider = "profile1-years", priority = 1)
	public void validSimulationProfile1Years(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath("//a[@class='btn btnAmarelo btnRefazer']")));
	}

	@Test(dataProvider = "profile2-months", priority = 2)
	public void validSimulationProfile2Months(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath("//a[@class='btn btnAmarelo btnRefazer']")));
	}

	@Test(dataProvider = "profile2-years", priority = 3)
	public void validSimulationProfile2Years(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulation.simulateInvestiment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(simulation.existElement(By.xpath("//a[@class='btn btnAmarelo btnRefazer']")));
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
