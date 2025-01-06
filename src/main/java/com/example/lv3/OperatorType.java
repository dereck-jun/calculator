package com.example.lv3;

import com.example.lv3.exception.ClientException;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    REMAIN("%");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    // symbol 값으로 OperatorType 리턴
    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol.equals(symbol)) {
                return type;
            }
        }
        throw new ClientException("지원하지 않는 연산 기호 입니다.");
    }
}
