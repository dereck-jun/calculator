package com.example.lv3.operation;

public interface Operator {
    <T extends Number> T operation(T firstNum, T secondNum, Class<T> type);
}
