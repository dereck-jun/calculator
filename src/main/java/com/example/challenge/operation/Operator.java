package com.example.challenge.operation;

public interface Operator<T extends Number> {
    Number operation(T firstInputNum, T secondInputNum);
}
