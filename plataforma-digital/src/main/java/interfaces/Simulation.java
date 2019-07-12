/**
 * 
 */
package interfaces;

/**
 * @author anderson.mann
 *
 */
public interface Simulation {

	/**
	 * This method select the profile type
	 * 
	 * @param type of profile "Para você" or "Para sua empresa ou agronegócio"
	 */
	void selectProfile(String profile);

	/**
	 * This method input the data at the field 'Qual o valor que você quer aplicar?'
	 * 
	 * @param initial value to apply
	 */
	void inputInitialValue(String value);

	/**
	 * This method input the data at the field 'Quanto você quer poupar todo mês?'
	 * 
	 * @param value to apply monthly
	 */
	void inputMonthlylValue(String value);

	/**
	 * This method input the data at the field 'Por quanto tempo você quer poupar?'
	 * 
	 * @param quantity of months or years
	 */
	void inputTime(String time);

	/**
	 * This method select the time type 'Meses'or 'years'
	 * 
	 * @param quantity of months or years
	 */
	void selectTimeType(String timeType);
	
	/**
	 * This method runs the flow of simulation
	 * @param profile
	 * @param initialValue
	 * @param monthlyValue
	 * @param time
	 * @param timeType
	 */
	void flowSimulateInvestment(String profile, String initialValue, String monthlyValue, String time,
			String timeType);

}
