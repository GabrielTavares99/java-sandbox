package greedy_algorithm.class_schedule;

import lombok.var;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class ClassScheduler {

    private final List<Class> classes;

    public ClassScheduler(List<Class> classes) {
        this.classes = classes;
    }

    public List<Class> getMaxNumberOfClasses() {
        var maxNumberOfClasses = new LinkedList<Class>();
        var availableClasses = new LinkedList<>(classes);

        Class lastClass = null;
        availableClasses.sort((e1, e2) -> e1.getStart().compareTo(e2.getStart()));

        while (!availableClasses.isEmpty()) {
            var currentClass = availableClasses.remove(0);

            final LocalTime startTime = currentClass.getStart();
            if (lastClass == null || (startTime.equals(lastClass.getEnd()) || startTime.isAfter(lastClass.getEnd()))) {
                maxNumberOfClasses.add(currentClass);
                lastClass = currentClass;
            }
        }

        System.out.println(maxNumberOfClasses);
        return maxNumberOfClasses;
    }
}
