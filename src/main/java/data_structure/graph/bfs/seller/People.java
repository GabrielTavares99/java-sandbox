package data_structure.graph.bfs.seller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class People {
    private String name;
    private boolean seller;

    public People(String name, boolean seller) {
        this.name = name;
        this.seller = seller;
    }

    public People(String name) {
        this.name = name;
    }
}
