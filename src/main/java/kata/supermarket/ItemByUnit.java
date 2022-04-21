package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;
    private final BigDecimal quantity;

    ItemByUnit(final Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    @Override
    public String name() {
        return this.product.name();
    }

    @Override
    public BigDecimal quantity() {
        return this.quantity;
    }

    @Override
    public ProductType type() {
        return ProductType.UNIT;
    }
}
