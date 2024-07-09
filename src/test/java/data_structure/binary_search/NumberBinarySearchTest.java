package data_structure.binary_search;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberBinarySearchTest {

    @ParameterizedTest
    @CsvSource(value = {
            "100,",
            "2,2",
            "6,6",
            "1,1"
    })
    void shouldSearchNumber(int target, Integer expected) {
        final NumberBinarySearch numberBinarySearch = new NumberBinarySearch();

        final Integer[] items = {1, 2, 3, 4, 5, 6, 7};
        Integer foundItem = numberBinarySearch.search(items, target);
        System.out.println(foundItem);

        Assertions.assertEquals(expected, foundItem);
    }

}
