package Lv3;

import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> a / b);

    private final char operator;
    private final DoubleBinaryOperator operation;

    OperatorType(char operator, DoubleBinaryOperator operation) {
        this.operator = operator;
        this.operation = operation;
    }

    // 기호 가져오기
    public char getOperator() {
        return operator;
    }

    // 연산식 가져오기
    public DoubleBinaryOperator getOperation() {
        return operation;
    }
}