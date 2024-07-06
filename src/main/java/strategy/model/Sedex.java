package strategy.model;

public class Sedex implements Freight {
    @Override
    public double calcFreight(int distanceKm) {
        return distanceKm * 1.5;
    }

    @Override
    public double calcTax() {
        return 0;
    }


}
