package ch.noseryoung.testingNums.kgvGgt;

/** This class generates the kgv of two different numbers
 * 
 * @author scheidmann
 *
 */
public class GenerateKGV {
	
	/** This method generates the kgv of two different numbers
	 * 
	 * @param num1 First number
	 * @param num2 Second number
	 * @return the kgv
	 */
	public static int generate(int num1, int num2) {		
		return num1 * num2 / GenerateGGT.generate(num1, num2).getAsInt();
	}
}
