package com.example.lv3.operation;

public class SubtractOperator<T extends Number> implements Operator<T> {
    @Override
    public Number operation(T firstNum, T secondNum) {
        return firstNum.doubleValue() - secondNum.doubleValue();
    }
}
