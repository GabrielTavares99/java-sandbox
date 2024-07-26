package data_structure.graph.bfs.generic;

import java.util.*;

public class Graph {

    Map<String, State> index = new HashMap<>();

    public void add(State state) {
        index.put(state.getName(), state);
    }

    public void add(List<State> states) {
        for (State state : states) {
            add(state);
        }
    }

    public State get(State state) {
        if (state == null) return null;
        return index.get(state.getName());
    }

    public boolean isLinked(State initialState, State finalState) {
        Queue<State> nextStatesToVisit = new ArrayDeque<>();
        nextStatesToVisit.add(initialState);
        Set<State> visitedStates = new HashSet<>();
        State lastVisited = null;
        while (!nextStatesToVisit.isEmpty()) {
            State currentState = nextStatesToVisit.poll();

            if (visitedStates.contains(currentState) || (lastVisited != null && !lastVisited.getNeighbors().contains(currentState)))
                continue;

            System.out.println(currentState);
            if (currentState.getNeighbors().contains(finalState) || currentState.equals(finalState)) {
                System.out.println(finalState);
                return true;
            }

            visitedStates.add(currentState);
            lastVisited = currentState;
            currentState.getNeighbors().stream()
                    .filter(e -> !visitedStates.contains(e))
                    .forEach(nextStatesToVisit::add);
        }

        return false;
    }

}
