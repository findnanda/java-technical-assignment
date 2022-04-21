package kata.supermarket;

import kata.supermarket.discountrules.BuyOneGetOneFree;
import kata.supermarket.discountrules.Discount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    //This can be directly injected if we use all of the compoenets as Spring beans but for now
    //I am initializing the static list here
    private final List<Discount> discountRules;
    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
        this.discountRules = new ArrayList<>();
        discountRules.add(new BuyOneGetOneFree());
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(item -> item.price().multiply(item.quantity()))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of
         *  the discount calculations.
         *  It is not likely to be the best place to do those calculations.
         *  Think about how Basket could interact with something
         *  which provides that functionality.
         */
        private BigDecimal discounts() {
            return discountRules.stream()
                    .map(discount -> discount.apply(items))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_DOWN);
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
