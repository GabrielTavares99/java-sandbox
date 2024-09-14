package greedy_algorithm.class_schedule;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@ToString
public class Class {

    private String subject;
    private LocalTime start;
    private LocalTime end;

    public Class(String subject, LocalTime start, LocalTime end) {
        this.subject = subject;
        this.start = start;
        this.end = end;
    }
}
