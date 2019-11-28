package ch.noseryoung.testingNums.kgvGgt;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/** This class generates the ggt of two different ints
 * 
 * @author scheidmann
 *
 */
public class GenerateGGT {
	
	/** This method creates the ggt of two numbers.
	 * 
	 * @param num1 First number
	 * @param num2 Second number
	 * @return the ggt
	 */
	public static OptionalInt generate(int num1, int num2) {
	
		return IntStream.rangeClosed(1, num1).filter(num -> num1 % num == 0).filter(num -> num2 % num == 0).max();
	}
}
