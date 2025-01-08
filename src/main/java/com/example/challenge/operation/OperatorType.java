package com.example.challenge.operation;

import com.example.challenge.exception.BaseException;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    LEFT_BRACE('('),
    RIGHT_BRACE(')');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static boolean isOperator(String operator) {
        for (OperatorType type : OperatorType.values()) {
            if (String.valueOf(type.symbol).equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static OperatorType fromSymbol(char operator) {
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol == operator) {
                return type;
            }
        }
        throw new BaseException("지원하지 않는 연산 기호입니다.");
    }

    public char getSymbol() {
        return symbol;
    }
}
