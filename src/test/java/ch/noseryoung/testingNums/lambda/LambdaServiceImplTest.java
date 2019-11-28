package ch.noseryoung.testingNums.lambda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
class LambdaServiceImplTest {

    @InjectMocks
    private LambdaServiceImpl lambdaService = new LambdaServiceImpl();

    @Test
    public void generatePrimes_requestMaxValue11_expect3Primes() {
        int[] collectionOfPrimes = lambdaService.generatePrimes(11);
        Assertions.assertThat(collectionOfPrimes).isNotEmpty().startsWith(2).endsWith(7);
    }

    @Test
    public void generatePrimes_requestMaxValue1_expectNothing() {
        int[] collectionOfPrimes = lambdaService.generatePrimes(1);
        Assertions.assertThat(collectionOfPrimes).isEmpty();
    }

    @Test
    public void generatePrimes_requestMaxValue0_expectNothing() {
        int[] collectionOfPrimes = lambdaService.generatePrimes(0);
        Assertions.assertThat(collectionOfPrimes).isEmpty();
    }

    @Test
    public void generatePrimes_requestMaxValueMinus1_expectNothing() {
        int[] collectionOfPrimes = lambdaService.generatePrimes(-1);
        Assertions.assertThat(collectionOfPrimes).isEmpty();
    }

    @Test
    public void generateFibonacci_requestMaxValue11_expect5Numbers() {
        List<Integer> collectionOfPrimes = lambdaService.generateFibonacci(11);
        Assertions.assertThat(collectionOfPrimes).isNotEmpty().startsWith(1).endsWith(13);
    }

    @Test
    public void generateFibonacci_requestMaxValue1_expect1Number() {
        List<Integer> collectionOfPrimes = lambdaService.generateFibonacci(1);
        Assertions.assertThat(collectionOfPrimes).isNotEmpty().startsWith(1).endsWith(1);
    }

    @Test
    public void generateFibonacci_requestMaxValue0_expect1Number() {
        List<Integer> collectionOfPrimes = lambdaService.generateFibonacci(0);
        Assertions.assertThat(collectionOfPrimes).isNotEmpty().startsWith(1).endsWith(1);
    }

    @Test
    public void generateFibonacci_requestMaxValueMinus1_expect1Number() {
        List<Integer> collectionOfPrimes = lambdaService.generateFibonacci(-1);
        Assertions.assertThat(collectionOfPrimes).isNotEmpty().startsWith(1).endsWith(1);
    }
}