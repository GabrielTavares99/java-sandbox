package data_structure.graph.bfs.city;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Edge<T> {
    private Integer weight;
    private Node<T> data;

    public Edge(Node<T> data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(data, edge.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
