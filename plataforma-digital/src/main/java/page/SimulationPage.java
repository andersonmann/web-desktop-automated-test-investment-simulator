/**
 * 
 */
package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

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
			if (profile.equalsIgnoreCase("pessoa juridica")) {
				List<WebElement> rdBtProfile = driver.findElements(By.name("perfil"));
				boolean bValue = false;
				bValue = rdBtProfile.get(0).isSelected();
				if (bValue == true) {
					log.getTest().log(Status.INFO, "selecting the profile 'Para sua empresa ou agronegócio'");
					rdBtProfile.get(1).click();
				}
			} else {
				log.getTest().log(Status.INFO, "selecting the profile 'Para você'");
				return;
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
		write(By.id("tempo"), time);
	}

	public void selectTimeType(String timeType) {
		click(By.xpath("//span[@class='seta']"));
		if (timeType.equalsIgnoreCase("anos")) {
			log.getTest().log(Status.INFO, "selecting the option 'Anos'");
			click(By.xpath("//a[contains(text(),'Anos')]"));
		} else {
			log.getTest().log(Status.INFO, "selecting the option 'Meses'");
			return;
		}
	}

	public void clickSimuteButton() {
		log.getTest().log(Status.INFO, "clicking at the button SIMULAR");
		click(By.xpath("//button[@class='btn btnAmarelo btnSimular']"));
	}

	public void clickCleanFormkButton() {
		log.getTest().log(Status.INFO, "clicking at the button Limpar formulário");
		click(By.className("btn btnAmarelo btnSimular"));
	}

	public void flowSimulateInvestment(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		scrollTo();
		switchTo(0);
		selectProfile(profile);
		inputInitialValue(initialValue);
		inputMonthlylValue(monthlyValue);
		inputTime(time);
		selectTimeType(timeType);
	}

	public void simulateInvestiment(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		flowSimulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		clickSimuteButton();
	}

	public void inputDataAndCleanFields(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		flowSimulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		clickCleanFormkButton();
	}

}
