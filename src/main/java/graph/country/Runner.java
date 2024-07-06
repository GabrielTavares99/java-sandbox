package graph.country;

import lombok.var;

public class Runner {

    public static void main(String[] args) {

        System.out.println("GRAPH INITIATED");

        final var countryGraph = new Graph<String>();
        countryGraph.addVertex("Brazil");
        countryGraph.addVertex("Argentina");
        countryGraph.addVertex("Uruguay");

        countryGraph.addEdge(1, "Brazil", "Argentina");
        countryGraph.addEdge(2, "Brazil", "Uruguay");

        countryGraph.addEdge(1, "Argentina", "Uruguay");
        countryGraph.addEdge(1, "Argentina", "Brazil");

        countryGraph.addEdge(1, "Uruguay", "Argentina");
        countryGraph.addEdge(2, "Uruguay", "Brazil");

        countryGraph.print();
    }
}
