package greedy_algorithm.campingBag;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private String name;
    private Integer weight;
    private Integer importance;


}
