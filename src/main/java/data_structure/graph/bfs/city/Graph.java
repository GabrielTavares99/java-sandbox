package data_structure.graph.bfs.city;

import lombok.var;

import java.util.*;

public class Graph<T> {

    private Set<Node<T>> nodes = new HashSet<>();

    public void addNode(Node<T> node) {
        nodes.add(node);
    }

    public List<Node<T>> dijkstra(Node<T> startNode, Node<T> endNode) throws Exception {
        if (startNode.getValue().equals(endNode.getValue())) return Collections.emptyList();

        var distances = new HashMap<Node<T>, Integer>();
        nodes.forEach(e -> distances.put(e, e.getValue().equals(startNode.getValue()) ? 0 : Integer.MAX_VALUE));
        var parents = new HashMap<Node<T>, Node<T>>();
        final var settledNodes = new HashSet<Node<T>>();
        final var unsettledNodes = new LinkedList<Node<T>>(Collections.singletonList(startNode));
        final var path = new LinkedList<Node<T>>();

        while (!unsettledNodes.isEmpty()) {
            var currentNode = unsettledNodes.poll();
            for (var edge : currentNode.getOuts()) {
                final var newDistance = distances.get(currentNode) + edge.getWeight();
                if (newDistance < distances.get(edge.getData())) {
                    parents.put(currentNode, edge.getData());
                    distances.put(edge.getData(), newDistance);
                }
                unsettledNodes.add(edge.getData());
            }

            settledNodes.add(currentNode);
            final var optionalEntry = distances.entrySet().stream()
                    .filter(e -> !settledNodes.contains(e.getKey()))
                    .min(Comparator.comparingInt(Map.Entry::getValue));

            if (!optionalEntry.isPresent())
                break;

            unsettledNodes.add(optionalEntry.get().getKey());
        }

        var stepNode = startNode;
        path.add(stepNode);
        var hasItem = true;
        while (hasItem) {
            stepNode = parents.get(stepNode);
            path.add(stepNode);
            if (stepNode.equals(endNode))
                hasItem = false;
        }
        return path;
    }

}
