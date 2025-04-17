package Lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    // 기호 가져오기
    public char getOperator() {
        return operator;
    }
}