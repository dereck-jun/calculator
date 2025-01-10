package com.example.lv3.operation;

import java.math.BigDecimal;

import static com.example.lv3.NumberUtils.castToType;
import static com.example.lv3.NumberUtils.convertToBigDecimal;

public class RemainOperator implements Operator {
    @Override
    public <T extends Number> T operation(T firstNum, T secondNum, Class<T> type) {
        BigDecimal divisor = convertToBigDecimal(secondNum);
        if (BigDecimal.ZERO.compareTo(divisor) == 0) {
            throw new ArithmeticException();
        }
        BigDecimal divide = convertToBigDecimal(firstNum).remainder(divisor);
        return castToType(divide, type);
    }
}
