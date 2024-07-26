package data_structure.graph.bfs.seller_oo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Queue;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private boolean seller;
    @ToString.Exclude
    private Queue<Person> friends;

    public Person(String name, boolean seller) {
        this.name = name;
        this.seller = seller;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, boolean seller, Queue<Person> friends) {
        this.name = name;
        this.seller = seller;
        this.friends = friends;
    }

    public Person(String name, Queue<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
