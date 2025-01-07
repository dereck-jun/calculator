package com.example.lv3.operation;

public class RemainOperator<T extends Number> implements Operator<T> {
    @Override
    public Number operation(T firstNum, T secondNum) {
        if (secondNum.doubleValue() == 0) {
            throw new ArithmeticException();
        }
        return firstNum.doubleValue() % secondNum.doubleValue();
    }
}
