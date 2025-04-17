package Lv3;

import java.util.List;
import java.util.stream.Collectors;

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

    public <T extends Number> void printHighResultList (Calculator<Number> calculator, T num) {
        List<Number> highResultList = calculator.getResultList()
                .stream()
                .filter(number -> num.doubleValue() < number.doubleValue())
                .collect(Collectors.toList());
        System.out.println(highResultList);
    }
}
