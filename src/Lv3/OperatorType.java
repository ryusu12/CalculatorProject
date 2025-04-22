package Lv3;

import java.math.MathContext;

public enum OperatorType {
    PLUS('+', (a, b) ->  a.add(b)),
    MINUS('-', (a, b) ->  a.subtract(b)),
    MULTIPLY('*', (a, b) -> a.multiply(b)),
    DIVIDE('/', (a, b) -> a.divide(b, MathContext.DECIMAL32));

    private final char operator;
    private final BigDecimalOperation operation;

    OperatorType(char operator, BigDecimalOperation operation) {
        this.operator = operator;
        this.operation = operation;
    }

    // 기호 가져오기
    public char getOperator() {
        return operator;
    }

    // 연산식 가져오기
    public BigDecimalOperation getOperation() {
        return operation;
    }
}