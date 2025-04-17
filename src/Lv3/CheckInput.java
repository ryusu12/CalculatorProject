package Lv3;

import java.util.Scanner;

public class CheckInput {
    static Scanner scan = new Scanner(System.in);

    // 숫자 입력
    public Number inputNumber(String word) {
        while (true) {
            System.out.print(word +" 숫자를 입력하세요: ");
            String num = scan.nextLine();
            // 정수, 실수 둘 다 받을 수 있음
            try {
                if (num.contains(".")) {
                    return Double.parseDouble(num);
                } else {
                    return Integer.parseInt(num);
                }
            } catch (NumberFormatException e) {
                // 예외처리 : 숫자가 아닌 값 예방
                System.out.println("숫자를 다시 입력하세요 ");
            }
        }
    }

    // 사칙연산 기호 입력
    public char inputOperator() {
        char operator;
        loop:
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = scan.nextLine().charAt(0);
            // 예외처리 : +,-,*,/ 인지 확인
            for (OperatorType oper : OperatorType.values()) {
                if (oper.getOperator() == operator) {
                    break loop;
                }
            }
            System.out.println("사칙연산 기호를 다시 입력하세요 (+,-,*,/)");
        }
        return operator;
    }
}
