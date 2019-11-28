package ch.noseryoung.testingNums.primes;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/** This class generates primes by an algorithm from an ancient Greek guy, efficiently
 * 
 * @author Scheidmann
 */
public class SieveGeneratePrimes {

	
	/** This method generates primes until it reaches the max value given
	 * 
	 * @param maxValue the maximum value of the primes
	 * @return returns an int[] filled with the primes
	 */
	public static int[] generatePrimes(int maxValue) {
		
		IntPredicate erasthenes = num -> { for (int i = 2; i <= Math.sqrt(num); i++) { if (num % i == 0) { return false; } } return true; };
		
		return IntStream.range(2, maxValue).filter(erasthenes).toArray();
	}
	
}
