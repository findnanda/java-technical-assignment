package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {

    private final String name;
    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo, final String name) {
        this.pricePerKilo = pricePerKilo;
        this.name = name;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    String name(){
        return this.name;
    }
}
