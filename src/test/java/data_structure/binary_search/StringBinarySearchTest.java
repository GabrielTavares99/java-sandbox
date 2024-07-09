package data_structure.binary_search;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringBinarySearchTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Gabriela,Gabriela",
            "Gabs,",
            "Ana,Ana",
            "Natalia,Natalia",
            "Mariana,Mariana",
            "Zora,Zora",
    })
    void shouldSearchString(String target, String expected) {
        var numberBinarySearch = new StringBinarySearch();

        String[] names = {"Ana", "Bruno", "Carla", "Daniel", "Eduarda", "Felipe", "Gabriela",
                "Henrique", "Isabela", "Julio", "Karina", "Lucas", "Mariana",
                "Natalia", "Otavio", "Paula", "Quirino", "Rafael", "Sofia",
                "Tiago", "Ursula", "Vitor", "Wagner", "Xavier", "Yara", "Zora"};

        String foundItem = numberBinarySearch.search(names, target);
        System.out.println(foundItem);

        Assertions.assertEquals(expected, foundItem);
    }

}
