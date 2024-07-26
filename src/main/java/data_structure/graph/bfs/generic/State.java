package data_structure.graph.bfs.generic;

import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class State {
    private String name;

    @ToString.Exclude
    private List<State> neighbors;

    public void addNeighbor(State state) {
        if (this.neighbors == null)
            this.neighbors = new LinkedList<>();
        this.neighbors.add(state);
    }

    public void addNeighbors(List<State> states) {
        if (this.neighbors == null)
            this.neighbors = new LinkedList<>();
        this.neighbors.addAll(states);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
