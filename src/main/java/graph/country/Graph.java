package graph.country;

import lombok.Getter;
import lombok.Setter;
import lombok.var;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Graph<T> {

    private List<Vertex<T>> vertices = new ArrayList<>();
    private List<Edge<T>> edges = new ArrayList<>();

    public void addEdge(int weight, T init, T end) {
        final var sourceVertex = this.getVertex(init);
        final var targeVertex = getVertex(end);

        var edge = new Edge<>(weight, sourceVertex, targeVertex);
        sourceVertex.addOut(edge);
        targeVertex.addInput(edge);

        this.getEdges().add(edge);
    }

    public void addVertex(T data) {
        final var vertex = new Vertex<>(data);
        this.getVertices().add(vertex);
    }

    public Vertex<T> getVertex(T data) {
        return this.getVertices().stream()
                .filter(e -> e.getData().equals(data))
                .findFirst()
                .orElse(null);
    }

    public void print() {
        final var visits = new HashSet<Vertex<T>>();
        final var queue = new LinkedList<Vertex<T>>();
        final var initialVertex = this.getVertices().get(0);

        visits.add(initialVertex);
        queue.add(initialVertex);

        System.out.println(initialVertex.getData());
        while (!queue.isEmpty()) {
            final var currentVertex = queue.poll();
            for (var edge : currentVertex.getEdgesOut()) {
                final var vertex = edge.getEnd();
                if (!visits.contains(vertex)) {
                    visits.add(vertex);
//                    System.out.println(vertex.getData());
                    System.out.println(currentVertex.getData() + " " + edge.getWeight() + " " + vertex.getData());
                    queue.add(vertex);
                }
            }
        }
    }

//    public void print2() {
//        var queue = new LinkedList<Vertex<T>>();
//        var visits = new HashSet<Vertex<T>>();
//        final var initialVertex = this.getVertices().get(0);
//        queue.a
//
//    }
}
