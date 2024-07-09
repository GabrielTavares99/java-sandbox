package sort;

import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickSort {

    private Random random = new Random();

    public List<Integer> sort(List<Integer> list) {

        if (list.size() < 2)
            return list;

        var pivot = list.remove(random.nextInt(list.size()));

        final List<Integer> lowers = list.stream().filter(e -> e < pivot).collect(Collectors.toList());
        final List<Integer> uppers = list.stream().filter(e -> e > pivot).collect(Collectors.toList());

        System.out.printf("%s {%s} %s%n", lowers, pivot, uppers);

        var integers = new ArrayList<Integer>(sort(lowers));
        integers.add(pivot);
        integers.addAll(sort(uppers));

        return integers;
    }
}
