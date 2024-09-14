package k_nearest.movie_recomendation;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieAdviserTest {

    @Test
    void calcDistance() {
        final var priyanka = new User("Priyanka", 3, 4, 4, 1, 4);
        final var justin = new User("Justin", 4, 3, 5, 1, 5);

        final var movieAdviser = new MovieAdviser();
        final var distance = movieAdviser.calcDistance(priyanka, justin);
        Assertions.assertEquals(2L, distance);
    }

    @Test
    void calcDistance2() {
        final var priyanka = new User("Priyanka", 3, 4, 4, 1, 4);
        final var morpheus = new User("Morpheus", 2, 5, 1, 3, 1);

        final var movieAdviser = new MovieAdviser();
        final var distance = movieAdviser.calcDistance(priyanka, morpheus);
        Assertions.assertEquals(5L, distance);
    }

}
