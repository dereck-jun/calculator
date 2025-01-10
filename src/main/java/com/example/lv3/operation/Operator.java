package com.example.lv3.operation;

public interface Operator<T extends Number> {
    Number operation(T firstNum, T secondNum);
}
