package com.example.lv3;

import com.example.lv3.exception.ClientException;
import com.example.lv3.operation.*;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<T> numbers = new ArrayList<>();

    // 계산 후 결과 저장
    public Number calculate(T firstNum, T secondNum, OperatorType type) {
        Operator<T> operator;
        switch (type) {
            case PLUS -> {
                operator = new AddOperator<>();
                return operator.operation(firstNum, secondNum);
            }
            case MINUS -> {
                operator = new SubtractOperator<>();
                return operator.operation(firstNum, secondNum);
            }
            case MULTIPLY -> {
                operator = new MultiplyOperator<>();
                return operator.operation(firstNum, secondNum);
            }
            case DIVIDE -> {
                operator = new DivideOperator<>();
                return operator.operation(firstNum, secondNum);
            }
            case REMAIN -> {
                operator = new RemainOperator<>();
                return operator.operation(firstNum, secondNum);
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
            .forEach(num -> System.out.println("입력하신 " + input + "보다 큰 값: " + num + " "));
    }

    // 특정 인덱스의 값 변경
    public void updateDataAtIndex(int idx, T val) {
        if (numbers.isEmpty() || (numbers.size() - 1) < idx) {
            throw new ClientException("인덱스에 저장된 값이 없습니다. (입력한 인덱스 값: [" + idx + "])");
        }
        numbers.set(idx, val);
    }

    // 0 번째 인덱스 값 삭제
    public void removeFirstResult() {
        if (numbers.isEmpty()) {
            throw new ClientException("저장된 값이 없습니다.");
        }
        numbers.remove(0);
    }

    public List<T> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<T> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }
}
