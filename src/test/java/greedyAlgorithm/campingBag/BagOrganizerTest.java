package greedyAlgorithm.campingBag;

import greedy_algorithm.campingBag.BagOrganizer;
import greedy_algorithm.campingBag.Item;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

class BagOrganizerTest {

    @Test
    void shouldOrganize() {

        final Item water = Item.builder().name("water").weight(3).importance(10).build();
        final Item book = Item.builder().name("book").weight(1).importance(3).build();
        final Item food = Item.builder().name("food").weight(2).importance(9).build();
        final Item coat = Item.builder().name("coat").weight(2).importance(5).build();
        final Item camera = Item.builder().name("camera").weight(1).importance(6).build();

        final var items = Arrays.asList(water, book, food, coat, camera);
        final var expectedItems = new HashSet<Item>(Arrays.asList(water, food, camera));

        final BagOrganizer organizer = new BagOrganizer();
        final var organized = organizer.organize(items, 6);
        Assertions.assertEquals(expectedItems, organized);
    }

}
