package ch.noseryoung.testingNums.primes;

import java.util.ArrayList;

/** This class generates primes by brute force
 * 
 * @author Scheidmann
 */
public class GeneratePrimes {
	
	
	/** This method generates primes until it reaches the max value given
	 * 
	 * @param maxValue the maximum value of the primes
	 * @return returns an int[] filled with the primes
	 */
	public static int[] generatePrimes(int maxValue) {
		ArrayList<Integer> primesList = new ArrayList<>();
		
		for (int i = 2; i < maxValue; i++) {
			if (isPrime(i)) {
				primesList.add(i);
			}
		}
		
		int[] primes = new int[primesList.size()];
		
		for (int i = 0; i < primesList.size(); i++) {
			primes[i] = primesList.get(i);
		}
		
		return primes;
	}
	
	/** This method checks if the given int is a prime or not
	 * 
	 * @param num the int to check
	 * @return the result if it's a prime or not
	 */
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
