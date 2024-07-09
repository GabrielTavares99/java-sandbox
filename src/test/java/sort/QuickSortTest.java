package sort;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class QuickSortTest {

    @Test
    void quickSort() {
        final var quickSort = new QuickSort();

        var items = new ArrayList<Integer>(Arrays.asList(9, 0, 8, 10, 7, 3, 2, 1, 6, 5, 4));
        final var response = quickSort.sort(items);

        System.out.printf("RESPONSE %s%n", Arrays.toString(response.toArray()));

        var expected = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assertions.assertEquals(expected, response);
    }

}
