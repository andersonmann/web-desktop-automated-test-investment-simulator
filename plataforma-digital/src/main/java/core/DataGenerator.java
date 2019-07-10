/**
 * 
 */
package core;

import java.util.Random;

/**
 * @author anderson.mann
 *
 */
public class DataGenerator {

	public static void main(String[] args) {

		int v = generateValue();

		System.out.println("valor " + v);

	}

	public static int generateValue() {
		Random rand = new Random();
		int n = rand.nextInt(50000);
		return n += 1;
	}
}
