package data_structure.binary_search;

import lombok.var;

import java.util.Arrays;

public class StringBinarySearch implements IBinarySearch<String> {

    public String search(String[] items, String target) {
        System.out.printf("LOOP:: %d %s%n", items.length, Arrays.toString(items));
        if (items == null || items.length == 0) return null;

        var middle = items.length / 2;
        final var compared = items[middle].compareTo(target);
        if (compared == 0) return items[middle];

        if (compared > 0) return search(Arrays.copyOfRange(items, 0, middle), target);
        else return search(Arrays.copyOfRange(items, middle + 1, items.length), target);
    }


}
