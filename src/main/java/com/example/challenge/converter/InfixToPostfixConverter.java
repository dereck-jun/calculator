package com.example.challenge.converter;

import static com.example.challenge.operation.OperatorType.*;

public class InfixToPostfixConverter extends AbstractExpressionProcessor {
    private StringBuilder postfixResult = new StringBuilder();

    private static String replaceExpression(String expression) {
        expression = expression.trim()
            .replace("(", " ( ")
            .replace(")", " ) ")
            .replace("+", " + ")
            .replace("-", " - ")
            .replace("*", " * ")
            .replace("/", " / ")
            .replace("  ", " ");
        return expression;
    }

    @Override
    public String process(String expression) {
        // 공백 처리
        expression = replaceExpression(expression);
        String[] splitWhiteSpace = expression.split(" ");

        for (String str : splitWhiteSpace) {
            if (str.isBlank()) {
                continue;
            }
            // 숫자일 경우 바로 리스트에 추가
            if (!isOperator(str)) {
                convertList.add(str + " ");
            } else {
                // 괄호일 경우 방향에 따라 다르게 처리
                if (fromSymbol(str.charAt(0)).equals(LEFT_BRACE)) {
                    operatorStack.push(str.charAt(0));
                } else if (fromSymbol(str.charAt(0)).equals(RIGHT_BRACE)) {
                    while (operatorStack.peek() != LEFT_BRACE.getSymbol() && !operatorStack.empty()) {
                        convertList.add(operatorStack.pop().toString() + " ");
                    }
                    operatorStack.pop();
                } else {
                    // 괄호를 제외한 연산 기호는 스택에 저장된 값과 우선 순위를 비교
                    if (operatorStack.empty() || priority(operatorStack.peek()) < priority(str.charAt(0))) {
                        operatorStack.push(str.charAt(0));
                    } else if (priority(operatorStack.peek()) >= priority(str.charAt(0))) {
                        convertList.add(operatorStack.pop().toString() + " ");
                        operatorStack.push(str.charAt(0));
                    }
                }
            }
        }
        // 스택에 남은 연산자를 맨 뒤에 추가
        while (!operatorStack.empty()) {
            convertList.add(operatorStack.pop().toString() + " ");
        }
        for (String str : convertList) {
            postfixResult.append(str);
        }
        return postfixResult.toString();
    }

    // 연산 우선 순위를 임의로 매김
    private int priority(char operator) {
        return switch (fromSymbol(operator)) {
            case PLUS, MINUS -> 3;
            case MULTIPLY, DIVIDE -> 5;
            case LEFT_BRACE, RIGHT_BRACE -> 1;
        };
    }
}
