package greedyAlgorithm.class_scheduler;

import greedy_algorithm.class_schedule.Class;
import greedy_algorithm.class_schedule.ClassScheduler;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;

class ClassSchedulerTest {

    @Test
    void shouldGetMaxNumberOfClasses() {
        final var arts = new Class("Arts", LocalTime.of(9, 0), LocalTime.of(10, 0));
        final var english = new Class("English", LocalTime.of(9, 30), LocalTime.of(10, 30));
        final var math = new Class("Math", LocalTime.of(10, 0), LocalTime.of(11, 0));
        final var cc = new Class("CC", LocalTime.of(10, 30), LocalTime.of(11, 30));
        final var music = new Class("Music", LocalTime.of(11, 0), LocalTime.of(12, 0));

        final var classes = Arrays.asList(arts, english, math, cc, music);

        final var classScheduler = new ClassScheduler(classes);

        final var expectedClasses = Arrays.asList(arts, math, music);

        Assertions.assertEquals(expectedClasses, classScheduler.getMaxNumberOfClasses());
    }

}
