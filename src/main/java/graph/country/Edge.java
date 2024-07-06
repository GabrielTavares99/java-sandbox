package graph.country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge<T> {
    private Integer weight;
    private Vertex<T> init;
    private Vertex<T> end;

    public Edge(Integer weight, Vertex<T> init, Vertex<T> end) {
        this.weight = weight;
        this.init = init;
        this.end = end;
    }


}
