package recursion;

import java.util.Arrays;

public class GeneralExamples {

    public Integer sum(Integer[] items) {
        System.out.println(Arrays.toString(items));
        if (items.length == 0) return 0;
        Integer[] newItems = Arrays.copyOfRange(items, 1, items.length);
        return items[0] + sum(newItems);
    }

    public Integer maxValue(Integer[] items) {
        System.out.println(Arrays.toString(items));

        if (items.length == 1) return items[0];

        if (items[0] > items[1])
            items[1] = items[0];

        Integer[] newItems = Arrays.copyOfRange(items, 1, items.length);
        return maxValue(newItems);
    }

    public int countItems(Integer[] items) {
        if (items.length == 0) return 0;
        Integer[] newItems = Arrays.copyOfRange(items, 1, items.length);
        return 1 + countItems(newItems);
    }

}
