/**
 * 
 */
package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import core.BaseTest;
import page.SimulationPage;

/**
 * @author anderson.mann
 *
 */
public class FieldsValidationTest extends BaseTest {
	private SimulationPage simulation = new SimulationPage();

	@Test
	public void validateMandatoryFields1() {
		simulation.validateMandatoryFields();
		assertEquals("Valor mínimo de 20.00", simulation.getValue(By.id("valorAplicar-error")));
	}

	@Test
	public void validateMandatoryFields2() {
		simulation.validateMandatoryFields();
		assertEquals("Valor mínimo de 20.00", simulation.getValue(By.id("valorInvestir-error")));
	}

	@Test
	public void validateMandatoryFields3() {
		simulation.validateMandatoryFields();
		assertEquals("Obrigatório", simulation.getValue(By.id("tempo-error")));
	}
}
