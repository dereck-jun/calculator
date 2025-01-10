package com.example.lv3.operation;

import java.math.BigDecimal;

import static com.example.lv3.NumberUtils.castToType;
import static com.example.lv3.NumberUtils.convertToBigDecimal;

public class SubtractOperator implements Operator {
    @Override
    public <T extends Number> T operation(T firstNum, T secondNum, Class<T> type) {
        BigDecimal subtract = convertToBigDecimal(firstNum).subtract(convertToBigDecimal(secondNum));
        return castToType(subtract, type);
    }
}
