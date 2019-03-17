package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

//        List<Long> numeros = new ArrayList<>();
//        for (long i = 1; i <= BigInteger.valueOf(100000L).longValue(); i++) {
//            numeros.add(i);
//        }
//
//        numeros.forEach(numero -> {
//            System.out.printf("%d ", numero);
//        });


        Random random = new Random();
        List<Integer> notasEnem = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            notasEnem.add(random.nextInt(999) + 1);
        }

        double mediaSimples = 0.0;
        for (Integer i : notasEnem) {
            mediaSimples += i;
        }
        System.out.println(mediaSimples / notasEnem.size());

        double media = notasEnem.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println(media);


    }
}
