/**
 * 
 */
package test;

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

//	@DataProvider(name = "user-passwd-ok")
//	public static Object[][] login0() {
//		return new Object[][] { { user, psswd } };
//	}

//	@Test(dataProvider = "user-passwd-ok", priority = 0)
	
//	@Test(priority = 0)
//	public void validSimulation() {//String profile, String initialValue, String monthlyValue, String time,String timeType
//		simulation.simulateInvestiment("pessoa juridica", "50000", "20000", "12", "meses");
//	}

	@Test
	public void test() {
		simulation.switchTo(0);
		simulation.selectProfile("pessoa juridica");
		simulation.write(By.id("valorAplicar"), "2222");
		simulation.write(By.id("valorInvestir"), "99999");
		simulation.write(By.id("tempo"), "10");
		simulation.selectTimeType222();
		simulation.clickSimuteButton();
		esperar(3000);
	}

}
