package kata.supermarket;

import java.math.BigDecimal;

public interface Item {

    BigDecimal price();

    String name();

    BigDecimal quantity();

    ProductType type();
}
