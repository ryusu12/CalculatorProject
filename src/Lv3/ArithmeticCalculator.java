package Lv3;

public class ArithmeticCalculator {
    // 사칙연산을 수행하는 메서드
    public <T extends Number> double calculate(T num1, T num2, char operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        if (operator == OperatorType.PLUS.getOperator()) {
            return a + b;
        } else if (operator == OperatorType.MINUS.getOperator()) {
            return a - b;
        } else if (operator == OperatorType.MULTIPLY.getOperator()) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
