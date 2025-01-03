package com.example.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> numbers = new ArrayList<>();

    // 계산 후 결과 저장
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

    // 전체 출력
    public void printNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("[" + i + "]: " + numbers.get(i));
        }
    }

    // 단건 출력
    public void printNumber(int idx) {
        System.out.println("[" + idx + "]: " + numbers.get(idx));
    }

    // input 보다 큰 값 출력
    public void printNumbersGreaterThanInput(double input) {
        numbers.stream()
            .filter(num -> num > input)
            .forEach(num -> System.out.print("입력하신 " + input + "보다 큰 값: " + num + " "));

        System.out.println();   // 출력 이후 가시성을 위한 개행
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    // 특정 인덱스의 값 변경
    public void setNumbers(int idx, double val) {
        numbers.set(idx, val);
    }

    // 0 번째 인덱스 값 삭제
    public void removeFirstResult() {
        numbers.remove(0);
    }
}
