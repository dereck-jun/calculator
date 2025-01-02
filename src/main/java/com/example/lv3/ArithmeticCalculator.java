package com.example.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> numbers = new ArrayList<>();

    public double calculateAndSave(T num1, T num2, OperatorType type) {
        double result = 0;
        switch (type) {
            case PLUS -> {
                result = num1.doubleValue() + num2.doubleValue();
                numbers.add(result);
            }
            case MINUS -> {
                result = num1.doubleValue() - num2.doubleValue();
                numbers.add(result);
            }
            case MULTIPLY -> {
                result = num1.doubleValue() * num2.doubleValue();
                numbers.add(result);
            }
            case DIVIDE -> {
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("0 으로 나눌 수 없습니다.");
                }
                result = num1.doubleValue() / num2.doubleValue();
                numbers.add(result);
            }
            default -> System.out.println("지원하지 않는 연산 기호입니다!");
        }
        return result;
    }

    public void printNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("[" + i + "]: " + numbers.get(i));
        }
    }

    public void printNumbersGreaterThanInput(double input) {
        numbers.stream()
            .filter(num -> num > input)
            .forEach(num -> System.out.print("입력하신 " + input + "보다 큰 값: " + num + " "));

        System.out.println();   // 출력 이후 가시성을 위한 개행
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(int idx, double val) {
        this.numbers = Collections.singletonList(numbers.set(idx, val));
    }

    public void removeFirstResult() {
        numbers.remove(0);
    }
}
