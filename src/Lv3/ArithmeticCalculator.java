package Lv3;

public class ArithmeticCalculator {
    // 사칙연산을 수행하는 메서드
    public int calculate(int num1, int num2, char operator) {
        int result;
        if (operator == OperatorType.PLUS.getOperator()) {
            result = num1 + num2;
        } else if (operator == OperatorType.MINUS.getOperator()) {
            result = num1 - num2;
        } else if (operator == OperatorType.MULTIPLY.getOperator()) {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }
        return result;
    }
}
