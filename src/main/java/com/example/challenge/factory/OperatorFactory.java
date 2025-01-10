package com.example.challenge.factory;

import com.example.challenge.exception.BaseException;
import com.example.challenge.operation.*;

public class OperatorFactory {
    public static <T extends Number> Operator<T> getOperator(OperatorType type) {
        return switch (type) {
            case PLUS -> new AddOperator<>();
            case MINUS -> new SubtractOperator<>();
            case MULTIPLY -> new MultiplyOperator<>();
            case DIVIDE -> new DivideOperator<>();
            default -> throw new BaseException("지원하지 않는 연산 기호입니다.");
        };
    }
}