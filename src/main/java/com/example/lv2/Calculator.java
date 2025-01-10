package com.example.lv2;

import com.example.lv2.exception.ClientException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Number> numbers = new ArrayList<>();

    public Number calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+' -> {
                return num1 + num2;
            }
            case '-' -> {
                return num1 - num2;
            }
            case '*' -> {
                return num1 * num2;
            }
            case '/' -> {
                if (num2 == 0) {
                    throw new ArithmeticException();
                }
                return ((double) num1 / num2);
            }
            default -> throw new ClientException("지원하지 않거나 잘못된 연산 기호입니다.");
        }
    }

    // 전체 출력
    public void printNumbers() {
        if (numbers.isEmpty()) {
            System.out.println("저장된 값이 없습니다.");
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.println("[" + i + "]: " + numbers.get(i));
            }
        }
    }

    // 단건 출력
    public void printNumber(int idx) {
        System.out.println("[" + idx + "]: " + numbers.get(idx));
    }

    // 0 번째 인덱스 값 삭제
    public void removeFirstResult() {
        numbers.remove(0);
    }

    // 특정 인덱스의 값 변경
    public void updateDataAtIndex(int idx, double val) {
        numbers.set(idx, val);
    }

    // 연산 후 결과 저장 & 출력
    public void printAndSaveResult(Number result) {
        numbers.add(result);
        System.out.println("작업 결과: " + result);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }
}