package Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // 정수 입력 받음
    private int inputNumber(String word, boolean allowNegative) {
        Scanner scan = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print(word + " 숫자를 입력하세요: ");
            // 예외처리 : 정수가 아닌 값 예방
            try {
                num = scan.nextInt();
                // 추가 기능 수행 중에는 음의 정수도 포함
                if (allowNegative) break;
                // 예외처리 : 양의 정수(0 포함)가 아니면 다시 입력받기
                if (num < 0) {
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
    private char inputOperator() {
        Scanner scan = new Scanner(System.in);
        char operator;
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요: ");
            String userInput = scan.nextLine();
            // 예외처리 : +,-,*,/ 인지 확인
            if (userInput.equals("+") || userInput.equals("-") || userInput.equals("*") || userInput.equals("/")) {
                operator = userInput.charAt(0);
                break;
            } else {
                System.out.println("사칙연산 기호를 다시 입력하세요 (+,-,*,/)");
            }
        }
        return operator;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);
        App app = new App();

        System.out.println("=== 계산기 프로그램 ===");
        loopExit:
        while (true) {
            // 1. 양의 정수를 입력받기
            int num1 = app.inputNumber("첫 번째", false);
            int num2 = app.inputNumber("두 번째", false);
            // 2. 사칙연산 기호를 입력받기
            char operator = app.inputOperator();

            // 예외처리 : 나눗셈에서 분모가 0이면 다시 입력받기
            if (num2 == 0 && operator == '/') {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            // 3. 연산 진행
            int result = calculator.calculate(num1, num2, operator);
            System.out.println("\n결과: " + num1 + " " + operator + " " + num2 + " = " + result);
            System.out.println("연산결과 : " + calculator.getResultList());

            loopContinue:
            // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            while (true) {
                System.out.println("더 계산하시겠습니까? (exit: 종료 / 그 외: 계속 계산하기)");
                System.out.println("추가 기능: (show: 결과 확인하기 / set: 결과 변경하기 / remove: 결과 삭제하기 / first: 가장 먼저 저장된 결과 삭제하기)");
                String userInput = scan.nextLine();
                switch (userInput) {
                    case "exit": {
                        break loopExit;
                    }
                    case "show": {
                        System.out.println("연산결과 : " + calculator.getResultList() + "\n");
                        break;
                    }
                    case "set": {
                        int changeNum = app.inputNumber("변경 할", true);
                        int setNum = app.inputNumber("새로 들어갈", true);
                        calculator.setResult(changeNum, setNum);
                        System.out.println("연산결과 : " + calculator.getResultList() + "\n");
                        break;
                    }
                    case "remove": {
                        int deleteNum = app.inputNumber("삭제 할", true);
                        calculator.removeResult(deleteNum);
                        System.out.println("연산결과 : " + calculator.getResultList() + "\n");
                        break;
                    }
                    case "first": {
                        calculator.removeFirstResult();
                        System.out.println("연산결과 : " + calculator.getResultList() + "\n");
                        break;
                    }
                    default:
                        break loopContinue;
                }
            }
        }
        System.out.println("=== 프로그램 종료 ===");
    }
}