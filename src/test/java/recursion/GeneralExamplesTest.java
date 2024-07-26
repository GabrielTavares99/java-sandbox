package recursion;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeneralExamplesTest {

    @Test
    void shouldSum() {
        var expectedValue = 68;
        Integer[] items = {5, 8, 3, 10, 2, 9, 12, 4, 7, 8};

        final var simpleSum = new GeneralExamples();
        var result = simpleSum.sum(items);
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    void shouldFindMaxValue() {
        Integer[] items = {5, 8, 3, 10, 2, 9, 12, 57, 4, 7, 8};

        final var simpleSum = new GeneralExamples();
        var result = simpleSum.maxValue(items);
        Assertions.assertEquals(57, result);
    }

    @Test
    void shouldCountNumberOfItems() {
        Integer[] items = {5, 8, 3, 4, 7, 8, -20};

        final var simpleSum = new GeneralExamples();
        var result = simpleSum.countItems(items);
        Assertions.assertEquals(7, result);
    }

}
