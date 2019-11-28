package ch.noseryoung.testingNums.lambda;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class LambdaControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private LambdaService lambdaService;

    @BeforeEach
    public void setUp() {
        int[] empty = new int[0];
        int[] value = new int[4];
        value[0] = 2;
        value[1] = 3;
        value[2] = 5;
        value[3] = 7;

        given(lambdaService.generatePrimes(11)).willReturn(value);
        given(lambdaService.generatePrimes(1)).willReturn(empty);
        given(lambdaService.generatePrimes(0)).willReturn(empty);
        given(lambdaService.generatePrimes(-1)).willReturn(empty);

        given(lambdaService.generateFibonacci(11)).willReturn(Arrays.asList(1, 1, 3, 5, 8, 11, 13));
        given(lambdaService.generateFibonacci(1)).willReturn(Arrays.asList(0));
        given(lambdaService.generateFibonacci(0)).willReturn(Arrays.asList(0));
        given(lambdaService.generateFibonacci(-1)).willReturn(Arrays.asList(0));
    }

    @Test
    public void getPrimes_requestMaxValue11_expect4Primes() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/primes/{maxValue}", 11).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));

    }

    @Test
    public void getPrimes_requestMaxValue1_expectEmptyArray() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/primes/{maxValue}", 1).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));

    }

    @Test
    public void getPrimes_requestMaxValue0_expectEmptyArray() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/primes/{maxValue}", 0).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));

    }

    @Test
    public void getPrimes_requestMaxValueMinus1_expectEmptyArray() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/primes/{maxValue}", -1).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));

    }

    @Test
    public void getFibonacci_requestMaxValue11_expect7Numbers() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/fibonacci/{maxValue}", 11).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(7)));
    }

    @Test
    public void getFibonacci_requestMaxValue1_expect1Number() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/fibonacci/{maxValue}", 1).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    public void getFibonacci_requestMaxValue0_expect1Number() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/fibonacci/{maxValue}", 0).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    public void getFibonacci_requestMaxValueMinus1_expect1Number() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/fibonacci/{maxValue}", -1).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }
}