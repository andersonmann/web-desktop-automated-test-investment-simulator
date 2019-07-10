/**
 * 
 */
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;

import core.BasePage;
import interfaces.Simulation;

/**
 * @author anderson.mann
 *
 */
public class SimulationPage extends BasePage implements Simulation {

	public void selectProfile(String profile) {
		try {
			if (profile.equalsIgnoreCase("pessoa fisica")) {
				log.getTest().log(Status.INFO, "selecting the profile 'Para você'");
				click(By.id("//div[text()='Para você']"));
			}
			if (profile.equalsIgnoreCase("pessoa juridica")) {
				log.getTest().log(Status.INFO, "selecting the profile 'Para sua empresa ou agronegócio'");
				click(By.id("#formInvestimento > div:nth-child(1) > input[type=radio]:nth-child(4)"));
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Option not found: " + e.getMessage());
		}
	}

	public void inputInitialValue(String value) {
		log.getTest().log(Status.INFO, "typing value to apply");
		write(By.id("valorAplicar"), value);
	}

	public void inputMonthlylValue(String value) {
		log.getTest().log(Status.INFO, "typing value to invest");
		write(By.id("valorInvestir"), value);
	}

	public void inputTime(String time) {
		log.getTest().log(Status.INFO, "typing time to invest");
		write(By.id("valorInvestir"), time);
	}

	public void selectTimeType(String timeType) {
		// TODO Auto-generated method stub

	}

}
