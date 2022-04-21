package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit, final String name) {
        this.pricePerUnit = pricePerUnit;
        this.name = name;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item ofQuantity(int quantity) {
        return new ItemByUnit(this, new BigDecimal(quantity));
    }

    String name(){
       return this.name;
    }
}
