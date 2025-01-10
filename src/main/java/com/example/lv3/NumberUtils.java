package com.example.lv3;

import com.example.lv3.exception.ClientException;

import java.math.BigDecimal;

public class NumberUtils {
    public static <T extends Number> T castToType(BigDecimal result, Class<T> type) {
        return switch (type.getSimpleName()) {
            case "Integer" -> type.cast(result.intValue());
            case "Long" -> type.cast(result.longValue());
            case "Double" -> type.cast(result.doubleValue());
            case "BigDecimal" -> type.cast(result);
            default -> throw new ClientException("지원하지 않는 클래스입니다.");
        };
    }

    public static BigDecimal convertToBigDecimal(Number number) {
        return new BigDecimal(number.toString());
    }
}
