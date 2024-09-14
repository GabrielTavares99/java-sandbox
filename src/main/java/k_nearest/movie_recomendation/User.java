package k_nearest.movie_recomendation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class User {

    private String name;

    private Map<String, Integer> grades = new HashMap<>();

    public User(String name, Integer comedian, Integer action, Integer drama, Integer horror, Integer romance) {
        this.name = name;
        grades.put("comedian", comedian);
        grades.put("action", action);
        grades.put("drama", drama);
        grades.put("horror", horror);
        grades.put("romance", romance);
    }
}
