package Lv3;

import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator extends Calculator<Number> {
    // 사칙연산을 수행하는 메서드
    public <T extends Number> double calculate(T num1, T num2, OperatorType operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        double result = operator.getOperation().applyAsDouble(a, b);
        addResult(result);
        return result;
    }

    // 저장된 연산 결과들 중, 입력받은 값보다 큰 결과값들을 출력하는 메서드
    public <T extends Number> void printHighResultList (T num) {
        List<Number> highResultList = getResultList().stream()
                .filter(number -> num.doubleValue() < number.doubleValue())
                .collect(Collectors.toList());
        System.out.println(highResultList);
    }
}
