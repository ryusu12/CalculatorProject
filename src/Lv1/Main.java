package Lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== 계산기 프로그램 ===");
        while(true) {
            // 1. 양의 정수를 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 =  scan.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 =  scan.nextInt();
            scan.nextLine();

            // 예외처리 : 양의 정수(0 포함)가 아니면 다시 입력받기
            if( num1<0 || num2<0 ) {
                System.out.println("양의 정수 2개(0 포함)를 다시 입력하세요 ");
                continue;
            }

            // 2. 사칙연산 기호를 입력받기
            // 예외처리 : +,-,*,/ 가 아니면 다시 입력받기
            System.out.print("사칙연산 기호를 입력하세요: ");
            String userInput = scan.nextLine();
            if(!userInput.equals("+") && !userInput.equals("-") && !userInput.equals("*") && !userInput.equals("/")) {
                System.out.println("사칙연산 기호를 다시 입력하세요 (+,-,*,/)");
                continue;
            }
            char operator = userInput.charAt(0);

            // 3. 연산 진행
            int result = 0;
            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 - num2;
            } else {
                // 예외처리 : 나눗셈에서 분모가 0이면 다시 입력받기
                if(num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                }
                result = num1 / num2;
            }

            System.out.println("결과: " + result);

            // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String command =  scan.nextLine();
            if(command.equals("exit")) {
                break;
            }
        }
        System.out.println("=== 프로그램 종료 ===");
    }
}