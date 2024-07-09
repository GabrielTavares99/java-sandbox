package sort;

import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {


    public List<Integer> sort(List<Integer> list) {

        if (list.size() < 2)
            return list;

        var pivot = list.remove(0);

        final List<Integer> lowers = list.stream().filter(e -> e < pivot).collect(Collectors.toList());
        final List<Integer> uppers = list.stream().filter(e -> e > pivot).collect(Collectors.toList());

        System.out.printf("%s {%s} %s%n", lowers, pivot, uppers);

        var integers = new ArrayList<Integer>(sort(lowers));
        integers.add(pivot);
        integers.addAll(sort(uppers));

        return integers;
    }
}
