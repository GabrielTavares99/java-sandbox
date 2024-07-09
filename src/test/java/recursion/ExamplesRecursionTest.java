package recursion;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExamplesRecursionTest {

    @Test
    void shouldSum() {
        var expectedValue = 68;
        Integer[] items = {5, 8, 3, 10, 2, 9, 12, 4, 7, 8};

        final var simpleSum = new ExamplesRecursion();
        var result = simpleSum.sum(items);
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    void shouldFindMaxValue() {
        Integer[] items = {5, 8, 3, 10, 2, 9, 12, 57, 4, 7, 8};

        final var simpleSum = new ExamplesRecursion();
        var result = simpleSum.maxValue(items);
        Assertions.assertEquals(57, result);
    }

}
