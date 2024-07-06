package graph.country;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vertex<T> {

    private T data;
    private List<Edge<T>> edgesIn = new ArrayList<>();
    private List<Edge<T>> edgesOut = new ArrayList<>();

    public Vertex(T data) {
        this.data = data;
    }

    public void addInput(Edge<T> edge) {
        this.getEdgesIn().add(edge);
    }

    public void addOut(Edge<T> edge) {
        this.getEdgesOut().add(edge);
    }

}
