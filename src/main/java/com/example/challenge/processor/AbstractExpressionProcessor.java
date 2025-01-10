package com.example.challenge.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractExpressionProcessor {
    protected final List<String> convertList = new ArrayList<>();
    protected final Stack<Character> operatorStack = new Stack<>();
    protected final Stack<String> operandStack = new Stack<>();

    public abstract String process(String expression);
}
