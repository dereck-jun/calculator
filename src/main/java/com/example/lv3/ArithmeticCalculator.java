package com.example.lv3;

import com.example.lv3.exception.ClientException;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<T> numbers = new ArrayList<>();

    // 계산 후 결과 저장
    public Number calculate(T num1, T num2, OperatorType type) {
        switch (type) {
            case PLUS -> {
                return num1.doubleValue() + num2.doubleValue();
            }
            case MINUS -> {
                return num1.doubleValue() - num2.doubleValue();
            }
            case MULTIPLY -> {
                return num1.doubleValue() * num2.doubleValue();
            }
            case DIVIDE -> {
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException();
                }
                return num1.doubleValue() / num2.doubleValue();
            }
            case REMAIN -> {
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException();
                }
                return num1.doubleValue() % num2.doubleValue();
            }
            default -> throw new ClientException("지원하지 않거나 잘못된 연산 기호입니다.");
        }
    }

    public void printAndSaveResult(T result) {
        numbers.add(result);
        System.out.println("연산 결과: " + result);
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
    public void printNumbersGreaterThanInput(Number input) {
        numbers.stream()
            .filter(num -> num.doubleValue() > input.doubleValue())
            .forEach(num -> System.out.print("입력하신 " + input + "보다 큰 값: " + num + " "));

        System.out.println();   // 출력 이후 가시성을 위한 개행
    }

    // 특정 인덱스의 값 변경
    public void updateDataAtIndex(int idx, T val) {
        numbers.set(idx, val);
    }

    // 0 번째 인덱스 값 삭제
    public void removeFirstResult() {
        numbers.remove(0);
    }

    public List<T> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<T> numbers) {
        this.numbers = numbers;
    }
}
