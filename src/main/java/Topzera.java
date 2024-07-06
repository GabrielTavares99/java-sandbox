import lombok.var;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Topzera {
    public static void main(String[] args) {
        var scoreboard = new HashMap<String, Integer>();

        var letters = Arrays.asList("a", "b", "c", "a", "b", "s");

        for (var letter : letters) {
            if (!scoreboard.containsKey(letter)) {
                scoreboard.put(letter, 1);
                continue;
            }

            var counter = scoreboard.get(letter) + 1;
            scoreboard.put(letter, counter);
        }

        final var counters = scoreboard.values().stream().mapToInt(v -> v).max().getAsInt();

        final var lettersMostUsed = scoreboard.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(counters))
                .collect(Collectors.toSet());

        System.out.println(lettersMostUsed);

    }
}
