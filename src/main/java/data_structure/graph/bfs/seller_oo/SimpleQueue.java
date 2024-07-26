package data_structure.graph.bfs.seller_oo;

import lombok.var;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class SimpleQueue {

    public static void main(String[] args) {

        final var eu = new Person("eu");
        final var mae = new Person("mae");
        final var pai = new Person("pai");
        final var irmao = new Person("irmao");
        final var amigoIrmao01 = new Person("amigo irmao 1");
        final var amigoIrmaoo2 = new Person("amigo irmao 2", true);

        eu.setFriends(new ArrayDeque<>(Arrays.asList(mae, pai, irmao)));
        pai.setFriends(new ArrayDeque<>(Arrays.asList(eu, irmao)));
        mae.setFriends(new ArrayDeque<>(Arrays.asList(eu, irmao)));
        irmao.setFriends(new ArrayDeque<>(Arrays.asList(amigoIrmao01, amigoIrmaoo2, pai, mae, eu)));

        var items = new ArrayDeque<Person>(eu.getFriends());
        var visited = new HashSet<Person>();
        while (items.peek() != null) {
            System.out.println("ROUND");

            final var person = items.remove();
            if (person.isSeller())
                System.out.printf("[%s] is a seller%n", person.getName());

            if (person.getFriends() != null)
                person.getFriends().stream().filter(e -> !visited.contains(e)).forEach(e -> {
                    visited.add(e);
                    items.add(e);
                });
        }
    }

}
