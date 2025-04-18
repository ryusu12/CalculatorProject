package Lv3;

import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    // 사칙연산을 수행하는 메서드
    public <T extends Number> double calculate(T num1, T num2, OperatorType operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        return operator.getOperation().applyAsDouble(a, b);
    }

    // 저장된 연산 결과들 중, 입력받은 값보다 큰 결과값들을 출력하는 메서드
    public <T extends Number> void printHighResultList (Calculator<Number> calculator, T num) {
        List<Number> highResultList = calculator.getResultList()
                .stream()
                .filter(number -> num.doubleValue() < number.doubleValue())
                .collect(Collectors.toList());
        System.out.println(highResultList);
    }
}
