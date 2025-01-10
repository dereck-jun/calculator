package com.example.challenge.operation;

public class SubtractOperator<T extends Number> implements Operator<T> {
    @Override
    public Number operation(T firstInputNum, T secondInputNum) {
        if (firstInputNum.doubleValue() % 1 != 0 || secondInputNum.doubleValue() % 1 != 0) {
            return firstInputNum.doubleValue() - secondInputNum.doubleValue();
        }
        return firstInputNum.longValue() - secondInputNum.longValue();
    }
}
