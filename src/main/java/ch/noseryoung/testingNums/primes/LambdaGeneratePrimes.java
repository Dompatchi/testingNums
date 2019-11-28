package ch.noseryoung.testingNums.primes;

import java.util.stream.IntStream;

/** This class generates primes by an obnoxious and confusing lambda, inefficiently
 * 
 * @author Scheidmann
 */
public class LambdaGeneratePrimes {

	/** This method generates primes until it reaches the max value given
	 * 
	 * @param maxValue the maximum value of the primes
	 * @return returns an int[] filled with the primes
	 */
	public static int[] generatePrimes(int maxValue) {
		return IntStream.range(2, maxValue).filter(num -> IntStream.rangeClosed(2, num/2).allMatch(i -> num % i != 0)).toArray();
	}
}
