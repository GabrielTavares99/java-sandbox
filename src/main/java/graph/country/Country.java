package graph.country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
