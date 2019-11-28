package ch.noseryoung.testingNums.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class GenerateFibonacci {
//    public static int[] generateFibonacciLambda(int maxValue) {
//        return IntStream.;
//        return new int[0];
//    }

    public static List<Integer> generateFibonacciBruteForce(int maxValue) {
        List<Integer> arr = new ArrayList<>();
        int counter = 0;
        arr.add(1);

        do {
            if(counter == 0) {
                arr.add(1);
            } else if (counter == 1) {
                arr.add(2);
            } else if (counter == 2) {
                arr.add(3);
            } else {
                arr.add(arr.get(counter) + arr.get(counter - 1));
            }

            counter++;

        } while (arr.get(counter) < maxValue);

        return arr;
    }
}
