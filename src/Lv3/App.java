package Lv3;

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);
    static CheckInput checkInput = new CheckInput();
    static Calculator<Number> calculator = new Calculator<>();

    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        System.out.println("=== 계산기 프로그램 ===");
        while(true) {
            // 1. 피연산자와 사칙연산를 입력받습니다.
            Number num1 = checkInput.inputNumber("첫 번째");
            Number num2 = checkInput.inputNumber("두 번째");
            char operator = checkInput.inputOperator();

            // 예외처리 : 나눗셈에서 분모가 0이면 처음부터 입력받습니다.
            if(num2.doubleValue() == 0.0 && operator=='/') {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            // 2. 연산 진행
            Number result =  arithmeticCalculator.calculate(num1, num2, operator);
            calculator.addResult(result);

            // 3. 연산 결과 출력
            System.out.println("\n결과: "+num1 + " " + operator + " " + num2 + " = "+ result);
            System.out.println("연산결과 : " + calculator.getResultList());

            // 3.1. 저장된 연산 결과들 중, 입력받은 값보다 큰 결과값들을 출력
            System.out.print("입력값보다 큰 결과값들 : " );
            arithmeticCalculator.printHighResultList(calculator, result);
            System.out.println("==================");

            // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            if (printLoop(calculator)) break;
        }
        System.out.println("=== 프로그램 종료 ===");
    }

    // 연산 후 작업
    // 상황에 따라 값 확인, 추가, 변경, 제거를 진행합니다.
    public static boolean printLoop(Calculator<Number> calculator) {
        while (true) {
            System.out.println("더 계산하시겠습니까? 아무거나 입력하세요");
            System.out.println("추가 기능: (exit = 종료 / show = 결과 확인하기 / set = 결과 변경하기 / remove = 결과 삭제하기)");
            String userInput = scan.nextLine();
            switch (userInput) {
                case "exit" : {
                    return true;
                }
                case "show" : {
                    System.out.println("연산결과 : " + calculator.getResultList() +"\n");
                    break;
                }
                case "set" : {
                    Number changeNum = checkInput.inputNumber("변경 할");
                    Number setNum = checkInput.inputNumber("새로 들어갈");
                    calculator.setResult(changeNum, setNum);
                    System.out.println("연산결과 : " + calculator.getResultList() +"\n");
                    break;
                }
                case "remove" : {
                    Number deleteNum = checkInput.inputNumber("삭제 할");
                    calculator.removeResult(deleteNum);
                    System.out.println("연산결과 : " + calculator.getResultList() +"\n");
                    break;
                }
                default: return false;
            }
        }
    }
}