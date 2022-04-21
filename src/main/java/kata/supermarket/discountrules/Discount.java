package kata.supermarket.discountrules;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public interface Discount {

    BigDecimal apply(List<Item> basket);

}
