import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.CalculatorService;
import service.TimeService;

import java.time.Duration;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class CalculatorServiceTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("I am before all tests ");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("I am after all tests ");
    }

    @BeforeEach
    public void beforeTest(TestInfo testInfo) {
        System.out.println("I am before test " + testInfo.getDisplayName());
    }

    @AfterEach
    public void afterTest(TestInfo testInfo) {
        System.out.println("I am after test " + testInfo.getDisplayName());
    }

    @Test
    void sumTest() {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(calculatorService.sum(1, 2.5), 3.5, 0);
    }

    @Test
    @DisplayName("Must multiply two numbers!")
    void multiple() {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(calculatorService.multiple(2, 10), 20, 0);
    }

    @Test
    public void throwException() {
        CalculatorService calculatorService = new CalculatorService();
        assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(2, 0);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "22"})
    void word_length(String word) {
        assertTrue(word.length() > 0);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, 10, 20",
            "30, 20, 50"
    })
    @DisplayName("SUM OPERATION")
    void sumOperation(int num1, int num2, int result) {
        CalculatorService calculatorService = new CalculatorService();
        int sumResult = (int) calculatorService.sum(num1, num2);
        assertEquals(sumResult, result);
    }

    @ParameterizedTest(name = "length [{0}] must have {1} characters")
    @CsvSource(value = {
            "'',0",
            "car,3"
    })
    @DisplayName("CALC A WORD LENGTH")
    void wordLength(String word, int expectedSize) {
        assertEquals(word.length(), expectedSize);
    }

    @RepeatedTest(10)
    @DisplayName("MUST GET TIME MACHINE BY N TIMES")
    void getMachineTime(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        assertTrue(currentTimeMillis > 0);
    }
}

