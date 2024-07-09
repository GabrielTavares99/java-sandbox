package sort;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SimpleSortTest {

    @Test
    void simpleSort() {
        final var simpleSort = new SimpleSort();

        Integer[] items = {3, 4, 1, 2};
        final var response = simpleSort.sort(items);
        System.out.println(Arrays.toString(response));

        Integer[] expected = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, response);
    }

}
