package com.example.lv3.operation;

import java.math.BigDecimal;

import static com.example.lv3.NumberUtils.castToType;
import static com.example.lv3.NumberUtils.convertToBigDecimal;

public class MultiplyOperator implements Operator {
    @Override
    public <T extends Number> T operation(T firstNum, T secondNum, Class<T> type) {
        BigDecimal multiply = convertToBigDecimal(firstNum).multiply(convertToBigDecimal(secondNum));
        return castToType(multiply, type);
    }
}
