import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class LegacyClassTest {

    @Test
    @DisplayName("Unused and Legacy multiplication")
    void unusedAndLegacyMultiplication() {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(calculatorService.multiple(2, 10), 20, 0);
    }

}
