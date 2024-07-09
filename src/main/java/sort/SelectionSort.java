package sort;

import lombok.var;

import java.util.Arrays;

public class SelectionSort implements ISort<Integer> {

    public Integer[] sort(Integer[] items) {
        for (var i = 0; i < items.length; i++) {
            System.out.println(Arrays.toString(items));
            for (var j = i + 1; j < items.length; j++) {
                if (items[i] > items[j]) {
                    var temp = items[j];
                    items[j] = items[i];
                    items[i] = temp;
                }
            }
        }
        return items;
    }

}
