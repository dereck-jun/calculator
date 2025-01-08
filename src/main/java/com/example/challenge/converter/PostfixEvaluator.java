package com.example.challenge.converter;

import com.example.challenge.exception.BaseException;
import com.example.challenge.operation.*;

import java.text.NumberFormat;
import java.text.ParseException;

import static com.example.challenge.operation.OperatorType.fromSymbol;
import static com.example.challenge.operation.OperatorType.isOperator;

public class PostfixEvaluator extends AbstractExpressionProcessor {
    @Override
    public String process(String expression) {
        Operator<Number> operator;
        String[] splitWhiteSpace = expression.split(" ");
        for (String item : splitWhiteSpace) {
            operandStack.push(item);

            if (isOperator(item)) {
                // 연산자 제거 용도
                operandStack.pop();

                Number firstInputNum;
                Number secondInputNum;
                try {
                    secondInputNum = NumberFormat.getInstance().parse(operandStack.pop());
                    firstInputNum = NumberFormat.getInstance().parse(operandStack.pop());
                } catch (ParseException e) {
                    throw new BaseException("문자열을 숫자로 파싱하는 과정에서 문제가 발생했습니다.");
                }

                StringBuilder result = new StringBuilder();

                switch (fromSymbol(item.charAt(0))) {
                    case PLUS -> {
                        operator = new AddOperator<>();
                        result.append(operator.operation(firstInputNum, secondInputNum));
                    }
                    case MINUS -> {
                        operator = new SubtractOperator<>();
                        result.append(operator.operation(firstInputNum, secondInputNum));
                    }
                    case MULTIPLY -> {
                        operator = new MultiplyOperator<>();
                        result.append(operator.operation(firstInputNum, secondInputNum));
                    }
                    case DIVIDE -> {
                        operator = new DivideOperator<>();
                        result.append(operator.operation(firstInputNum, secondInputNum));
                    }
                    default -> throw new IllegalArgumentException();
                }
                operandStack.push(result.toString());
            }
        }
        return operandStack.pop();
    }
}