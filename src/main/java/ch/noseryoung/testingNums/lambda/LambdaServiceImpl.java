package ch.noseryoung.testingNums.lambda;

import ch.noseryoung.testingNums.fibonacci.GenerateFibonacci;
import ch.noseryoung.testingNums.kgvGgt.GenerateGGT;
import ch.noseryoung.testingNums.kgvGgt.GenerateKGV;
import ch.noseryoung.testingNums.primes.LambdaGeneratePrimes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LambdaServiceImpl implements LambdaService {
    @Override
    public int[] generatePrimes(int maxValue) {
        return LambdaGeneratePrimes.generatePrimes(maxValue);
    }

    @Override
    public int generateGGT(int num1, int num2) {
        return GenerateGGT.generate(num1, num2).getAsInt();
    }

    @Override
    public int generateKGV(int num1, int num2) {
        return GenerateKGV.generate(num1, num2);
    }

    @Override
    public List<Integer> generateFibonacci(int maxNum) {
        return GenerateFibonacci.generateFibonacciBruteForce(maxNum);
    }
}
