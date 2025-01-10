package com.example.lv3.factory;

import com.example.lv3.operation.*;

public class OperatorFactory {
    public static <T extends Number> Operator<T> getOperator(OperatorType type) {
        return switch (type) {
            case PLUS -> new AddOperator<>();
            case MINUS -> new SubtractOperator<>();
            case MULTIPLY -> new MultiplyOperator<>();
            case DIVIDE -> new DivideOperator<>();
            case REMAIN -> new RemainOperator<>();
        };
    }
}
