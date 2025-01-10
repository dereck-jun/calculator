package com.example.lv3.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.lv3.NumberUtils.castToType;
import static com.example.lv3.NumberUtils.convertToBigDecimal;

public class DivideOperator implements Operator {
    @Override
    public <T extends Number> T operation(T firstNum, T secondNum, Class<T> type) {
        BigDecimal divisor = convertToBigDecimal(secondNum);
        if (BigDecimal.ZERO.compareTo(divisor) == 0) {
            throw new ArithmeticException();
        }
        BigDecimal divide = convertToBigDecimal(firstNum).divide(divisor, RoundingMode.HALF_UP);
        return castToType(divide, type);
    }
}
