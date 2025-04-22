package Lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    // 정수 입력 받음
    public static int inputNumber(String word) {
        int num;
        while (true) {
            System.out.print(word +" 숫자를 입력하세요: ");
            // 예외처리 : 정수가 아닌 값 예방
            try {
                num = scan.nextInt();
                // 예외처리 : 양의 정수(0 포함)가 아니면 다시 입력받기
                if( num < 0 ) {
                    System.out.println("양의 정수(0 포함)를 다시 입력하세요 ");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 다시 입력하세요 ");
            } finally {
                scan.nextLine();
            }
        }
        return num;
    }

    // 사칙연산 기호 입력 받음
    public static char inputOperator() {
        char operator;
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요: ");
            String userInput = scan.nextLine();
            // 예외처리 : +,-,*,/ 인지 확인
            if(userInput.equals("+") || userInput.equals("-") || userInput.equals("*") || userInput.equals("/")) {
                operator = userInput.charAt(0);
                break;
            } else {
                System.out.println("사칙연산 기호를 다시 입력하세요 (+,-,*,/)");
            }
        }
        return operator;
    }

    // 사칙연산
    public static int calculate(int num1, int num2, char operator) {
        int result;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== 계산기 프로그램 ===");
        while(true) {
            // 1. 양의 정수를 입력받기
            int num1 = inputNumber("첫 번째");
            int num2 = inputNumber("두 번째");
            // 2. 사칙연산 기호를 입력받기
            char operator = inputOperator();

            // 예외처리 : 나눗셈에서 분모가 0이면 다시 입력받기
            if(num2==0 && operator=='/') {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }
            // 3. 연산 진행
            int result = calculate(num1, num2, operator);
            System.out.println("결과: "+num1 + " " + operator + " " + num2 + " = "+ result);

            // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            System.out.println("더 계산하시겠습니까? (exit: 종료 / 그 외: 계속 계산하기)" );
            if(scan.nextLine().equals("exit")) {
                break;
            }
        }
        System.out.println("=== 프로그램 종료 ===");
    }
}