package ch.noseryoung.testingNums.lambda;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class LambdaIntegrationTest {

    @Autowired
    private LambdaController lambdaController;

    @Autowired
    private MockMvc mvc;

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
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void getFibonacci_requestMaxValue0_expect1Number() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/fibonacci/{maxValue}", 0).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void getFibonacci_requestMaxValueMinus1_expect1Number() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/nums/fibonacci/{maxValue}", -1).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }
}
