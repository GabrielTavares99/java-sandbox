package problem.hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class HotelDTO {
    private String name;
    private double distanceFromDowntown;
}
