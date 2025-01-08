package com.example.challenge;

import com.example.challenge.converter.AbstractExpressionProcessor;
import com.example.challenge.converter.InfixToPostfixConverter;
import com.example.challenge.converter.PostfixEvaluator;
import com.example.challenge.exception.BaseException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Number> operationResults = new ArrayList<>();
    private AbstractExpressionProcessor processor;

    // 수식 연산
    public Number calculate(String mathExpression) {
        Number parseNumber;

        String infixToPostfix = infixToPostfix(mathExpression);
        String evaluation = postfixEvaluation(infixToPostfix);

        try {
            parseNumber = NumberFormat.getInstance().parse(evaluation);
        } catch (ParseException e) {
            throw new BaseException("문자열을 숫자로 파싱하는 과정에서 문제가 발생했습니다.");
        }
        return parseNumber;
    }

    public void saveAndPrintResult(Number result) {
        operationResults.add(result);
        System.out.println("결과가 저장되었습니다. (저장된 결과: " + result + ")");
    }

    public List<Number> getOperationResults() {
        return operationResults;
    }

    public void setOperationResults(List<Number> operationResults) {
        this.operationResults = new ArrayList<>(operationResults);
    }

    // 전체 출력
    public void printNumbers() {
        for (int i = 0; i < operationResults.size(); i++) {
            System.out.println("[" + i + "]: " + operationResults.get(i));
        }
    }

    // 단건 출력
    public void printNumber(int idx) {
        System.out.println("[" + idx + "]: " + operationResults.get(idx));
    }

    // input 보다 큰 값 출력
    public void printNumbersGreaterThanInput(Number input) {
        operationResults.stream()
            .filter(num -> num.doubleValue() > input.doubleValue())
            .forEach(num -> System.out.println("입력하신 " + input + "보다 큰 값: " + num + " "));
    }

    // 특정 인덱스의 값 변경
    public void updateDataAtIndex(int idx, Number val) {
        if (operationResults.isEmpty() || (operationResults.size() - 1) < idx) {
            throw new BaseException("인덱스에 저장된 값이 없습니다. (입력한 인덱스 값: [" + idx + "])");
        }
        operationResults.set(idx, val);
    }

    // 0 번째 인덱스 값 삭제
    public void removeFirstResult() {
        if (operationResults.isEmpty()) {
            throw new BaseException("저장된 값이 없습니다.");
        }
        operationResults.remove(0);
    }

    private String infixToPostfix(String mathExpression) {
        processor = new InfixToPostfixConverter();
        return processor.process(mathExpression);
    }

    private String postfixEvaluation(String postfix) {
        processor = new PostfixEvaluator();
        return processor.process(postfix);
    }
}