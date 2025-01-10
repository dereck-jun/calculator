package com.example.challenge.operation;

import com.example.challenge.exception.BaseException;

public class DivideOperator<T extends Number> implements Operator<T> {
    @Override
    public Number operation(T firstInputNum, T secondInputNum) {
        if (secondInputNum.doubleValue() == 0) {
            throw new BaseException("0으로 나눌 수 없습니다.");
        }

        double result = firstInputNum.doubleValue() / secondInputNum.doubleValue();
        if (result % 1 == 0) {
            return (long) result;
        }

        return result;
    }
}
