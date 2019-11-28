package ch.noseryoung.testingNums.lambda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nums")
public class LambdaController {
    private LambdaService lambdaService;

    @Autowired
    public LambdaController(LambdaService lambdaService) {
        this.lambdaService = lambdaService;
    }

    @GetMapping("/primes/{maxValue}")
    public int[] getPrimes(@PathVariable int maxValue) {
        int[] primes = lambdaService.generatePrimes(maxValue);
        return primes;
    }

    @GetMapping("/fibonacci/{maxValue}")
    public List<Integer> getFibonacci(@PathVariable int maxValue) {
        List<Integer> fibonacci = lambdaService.generateFibonacci(maxValue);
        return fibonacci;
    }
}
