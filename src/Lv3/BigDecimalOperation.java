package Lv3;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalOperation {
    BigDecimal apply(BigDecimal a, BigDecimal b);
}