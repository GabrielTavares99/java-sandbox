package strategy.model;

public class UberEats implements Freight{
    @Override
    public double calcFreight(int distanceKm) {
        return 0;
    }

    @Override
    public double calcTax() {
        return 0;
    }
}
