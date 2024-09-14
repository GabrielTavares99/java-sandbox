package greedy_algorithm.campingBag;

import lombok.var;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BagOrganizer {

    public Set<Item> organize(List<Item> items, Integer maxWeight) {
        var response = new HashSet<Item>();

        items.sort((o2, o1) -> o1.getImportance().compareTo(o2.getImportance()));

        var currentWeight = 0;
        for (var item : items) {
            if ((item.getWeight() + currentWeight) <= maxWeight) {
                response.add(item);
                currentWeight += item.getWeight();
            }
        }
        System.out.println(response);
        return response;
    }

}
