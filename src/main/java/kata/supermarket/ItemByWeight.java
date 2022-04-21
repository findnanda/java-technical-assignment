package kata.supermarket;

import java.math.BigDecimal;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public BigDecimal price() {
        return product.pricePerKilo();
    }

    @Override
    public String name() {
        return this.product.name();
    }

    @Override
    public BigDecimal quantity() {
        return weightInKilos;
    }

    @Override
    public ProductType type() {
        return ProductType.WEIGHTED;
    }
}
