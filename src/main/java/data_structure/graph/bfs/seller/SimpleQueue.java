package data_structure.graph.bfs.seller;

import lombok.var;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class SimpleQueue {

    public static void main(String[] args) {

        var people = new HashMap<String, Queue<People>>();

        people.put("eu", new ArrayDeque<>(Arrays.asList(new People("pai"), new People("mae", true), new People("amigo do irmao 2", true), new People("irmao"))));
        people.put("mae", new ArrayDeque<>());
        people.put("pai", new ArrayDeque<>());
        people.put("irmao", new ArrayDeque<>(Arrays.asList(new People("amigo do irmao 1"), new People("amigo do irmao 2", true))));

        Queue<People> queue = people.get("eu");
        while (queue.peek() != null) {
            final var person = queue.remove();
            if (person.isSeller()) {
                System.out.printf("[%s] is a seller%n", person.getName());
//                break;
            }
            if (people.get(person.getName()) != null)
                queue.addAll(people.get(person.getName()));
        }
    }

}
