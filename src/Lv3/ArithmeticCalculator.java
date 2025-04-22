package Lv3;

import java.math.BigDecimal;

public class ArithmeticCalculator extends Calculator<BigDecimal> {
    // 사칙연산을 수행하는 메서드
    public <T extends BigDecimal> BigDecimal calculate(T num1, T num2, OperatorType operator) {
        BigDecimal result = operator.getOperation().apply(num1, num2).stripTrailingZeros();
        addResult(result);
        return result;
    }

    // 저장된 연산 결과들 중, 입력받은 값보다 큰 결과값들을 출력하는 메서드
    public <T extends BigDecimal> void printHighResultList(T num) {
        System.out.print("입력값보다 큰 결과값들 : ");
        getResultList().stream()
                .filter(result -> result.compareTo(num) > 0)
                .forEach(result ->
                        System.out.print(result.toPlainString() + " | ")
                );
        System.out.println();
    }

    // 연산결과 출력하는 메소드
    public void printResultList() {
        System.out.print("연산결과 : ");
        getResultList().forEach(result ->
                System.out.print(result.toPlainString() + " | ")
        );
        System.out.println();
    }
}
