package kata.supermarket.discountrules;

import kata.supermarket.Item;
import kata.supermarket.ProductType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BuyOneGetOneFree implements Discount {

    private static final BigDecimal BUY_ONE_GET_ONE_DISCOUNT = new BigDecimal(0.50);

    @Override
    public BigDecimal apply(List<Item> basket) {
        return basket.stream()
                .filter(item -> item.type().equals(ProductType.UNIT))
                .filter(item -> item.quantity().intValue() >= 2)
                .map(item -> calculateDiscount(item.price(), item.quantity()))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_DOWN);
    }

    private int discountQuantity(BigDecimal quantity) {
        return BUY_ONE_GET_ONE_DISCOUNT.multiply(quantity).intValue();
    }

    private BigDecimal calculateDiscount(final BigDecimal price, BigDecimal quantity) {
        return price.multiply(new BigDecimal(discountQuantity(quantity)));
    }
}
