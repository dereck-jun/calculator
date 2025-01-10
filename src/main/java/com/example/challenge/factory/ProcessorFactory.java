package com.example.challenge.factory;

import com.example.challenge.processor.AbstractExpressionProcessor;
import com.example.challenge.processor.InfixToPostfixProcessor;
import com.example.challenge.processor.PostfixEvaluationProcessor;
import com.example.challenge.processor.ProcessorType;

public class ProcessorFactory {
    public static AbstractExpressionProcessor getProcessor(ProcessorType type) {
        return switch (type) {
            case INFIX_TO_POSTFIX -> new InfixToPostfixProcessor();
            case POSTFIX_EVALUATION -> new PostfixEvaluationProcessor();
        };
    }
}
