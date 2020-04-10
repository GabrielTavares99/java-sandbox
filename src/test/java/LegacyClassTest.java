import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CalculatorService;

import static org.junit.Assert.assertEquals;

@Disabled
public class LegacyClassTest {

    @Test
    @DisplayName("Unused and Legacy multiplication")
    void unusedAndLegacyMultiplication() {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(calculatorService.multiple(2, 10), 20, 0);
    }

}
