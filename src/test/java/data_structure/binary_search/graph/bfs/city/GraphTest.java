package data_structure.binary_search.graph.bfs.city;

import data_structure.graph.bfs.city.City;
import data_structure.graph.bfs.city.Edge;
import data_structure.graph.bfs.city.Graph;
import data_structure.graph.bfs.city.Node;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

class GraphTest {

    @Test
    void dijkstra() throws Exception {
        final var graph = new Graph<City>();

        final var start = new Node<City>(new City("START"));
        final var cityA = new Node<City>(new City("CITY A"));
        final var cityB = new Node<City>(new City("CITY B"));
        final var cityC = new Node<City>(new City("CITY C"));
        final var cityD = new Node<City>(new City("CITY D"));
        final var end = new Node<City>(new City("END"));

        start.addOut(new Edge<>(cityA, 1));
        start.addOut(new Edge<>(cityB, 20));
        start.addOut(new Edge<>(cityC, 10));

        cityA.addOut(new Edge<>(end, 50));
        cityB.addOut(new Edge<>(end, 20));

        cityC.addOut(new Edge<>(cityD, 10));
        cityD.addOut(new Edge<>(end, 10));

        graph.addNode(start);
        graph.addNode(cityA);
        graph.addNode(cityB);
        graph.addNode(cityC);
        graph.addNode(cityD);
        graph.addNode(end);

        var shortestPath = graph.dijkstra(start, end);
        var expectedShortestPath = new LinkedList<Node<City>>(Arrays.asList(start, cityC, cityD, end));

        Assertions.assertEquals(expectedShortestPath, shortestPath);
    }

}
