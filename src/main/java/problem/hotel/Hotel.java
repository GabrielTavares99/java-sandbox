package problem.hotel;

import lombok.var;

import java.util.ArrayList;
import java.util.Comparator;


public class Hotel {
    public static void main(String[] args) {

        var hotels = new ArrayList<HotelDTO>();
        hotels.add(HotelDTO.builder()
                .name("A")
                .distanceFromDowntown(100)
                .build());
        hotels.add(HotelDTO.builder()
                .name("B")
                .distanceFromDowntown(50)
                .build());
        hotels.add(HotelDTO.builder()
                .name("C")
                .distanceFromDowntown(300)
                .build());
        hotels.add(HotelDTO.builder()
                .name("D")
                .distanceFromDowntown(20)
                .build());

        final var hotelDTO = hotels.stream().min(Comparator.comparing(HotelDTO::getDistanceFromDowntown)).get();

        hotels.sort(Comparator.comparing(HotelDTO::getDistanceFromDowntown));

        var max = Math.min(2, hotels.size());
        final var top3 = hotels.subList(0, 0);

        System.out.println("TOP 3 " + top3);
    }
}
