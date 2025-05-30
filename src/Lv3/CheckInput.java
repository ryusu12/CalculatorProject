package Lv3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class CheckInput {
    // 숫자 입력
    public BigDecimal inputNumber(String word) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(word + " 숫자를 입력하세요: ");
            String num = scan.nextLine();
            // 정수, 실수 둘 다 받을 수 있음
            try {
                return new BigDecimal(num).stripTrailingZeros();
            } catch (NumberFormatException e) {
                // 예외처리 : 숫자가 아닌 값 예방
                System.out.println("숫자를 다시 입력하세요 ");
            }
        }
    }

    // 사칙연산 기호 입력
    public OperatorType inputOperator() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scan.nextLine().charAt(0);

            // 예외처리 : +,-,*,/ 인지 확인
            OperatorType operatorType = Arrays.stream(OperatorType.values())
                    .filter(oper -> oper.getOperator() == operator)
                    .findFirst()
                    .orElse(null);

            if (operatorType == null) {
                System.out.println("사칙연산 기호를 다시 입력하세요 (+,-,*,/)");
            } else {
                return operatorType;
            }
        }
    }
}
