package com.example.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    private List<Double> numbers = new ArrayList<>();

    public double calculateAndSave(int num1, int num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+' -> {
                result = (double) num1 + num2;
                numbers.add(result);
            }
            case '-' -> {
                result = (double) num1 - num2;
                numbers.add(result);
            }
            case '*' -> {
                result = (double) num1 * num2;
                numbers.add(result);
            }
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                result = (double) num1 / num2;
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

    public void removeFirstResult() {
        numbers.remove(0);
        System.out.println("=== 삭제 후 결과 ===");
        for (Double number : numbers) {
            System.out.print(number + " | ");
        }
        System.out.println();   // 가독성을 위한 처리
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(int idx, double val) {
        this.numbers = Collections.singletonList(numbers.set(idx, val));
    }

    public boolean isEmptyList() {
        if (numbers.isEmpty()) {
            System.out.println("저장된 값이 없습니다.");
            return true;
        }
        return false;
    }
}
