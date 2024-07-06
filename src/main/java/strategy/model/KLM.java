package strategy.model;

public class KLM implements Freight {
    @Override
    public double calcFreight(int distanceKm) {
        return distanceKm * 0.5;
    }

    @Override
    public double calcTax() {
        return 0;
    }


}
