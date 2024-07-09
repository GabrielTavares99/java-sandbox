package data_structure.binary_search;

import lombok.var;

import java.util.Arrays;
import java.util.Objects;

public class NumberBinarySearch implements IBinarySearch<Integer> {

    public Integer search(Integer[] items, Integer target) {
        System.out.printf("LOOP:: %s%n", Arrays.toString(items));
        if (items == null || items.length == 0) return null;

        var middle = items.length / 2;
        if (Objects.equals(items[middle], target)) return items[middle];

        if (target < items[middle]) return search(Arrays.copyOfRange(items, 0, middle), target);
        else return search(Arrays.copyOfRange(items, middle + 1, items.length), target);
    }

}
