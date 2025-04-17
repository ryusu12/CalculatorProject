package Lv3;

import java.util.Scanner;

public class App {
    static CheckInput checkInput = new CheckInput();
    static Calculator<Number> calculator = new Calculator<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        System.out.println("=== 계산기 프로그램 ===");
        while(true) {
            // 1. 피연산자와 사칙연산를 입력받기
            Number num1 = checkInput.inputNumber("첫 번째");
            Number num2 = checkInput.inputNumber("두 번째");
            char operator = checkInput.inputOperator();

            // 예외처리 : 나눗셈에서 분모가 0이면 처음부터 입력받기
            if(num2.doubleValue() == 0.0 && operator=='/') {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            // 2. 연산 진행
            Number result =  arithmeticCalculator.calculate(num1, num2, operator);
            calculator.addResult(result);
            System.out.println("결과: "+num1 + " " + operator + " " + num2 + " = "+ result);

            // 3. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(scan.nextLine().equals("exit")) {
                break;
            }
        }
        System.out.println("==================");
        // 4. 연산 결과 출력
        printResult(calculator);
        System.out.println("=== 프로그램 종료 ===");
    }

    // 연산 결과 출력
    public static void printResult(Calculator<Number> calculator) {
        System.out.println("처음에 넣은 값 : " + calculator.getResult(0));
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");

        // 값 추가
        System.out.println("새로운 값 추가하기");
        Number addNum = checkInput.inputNumber("추가 할");
        calculator.addResult(addNum);
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");

        // 값 변경
        System.out.println(addNum+"을 새로운 값으로 변경 ");
        Number setNum = checkInput.inputNumber("변경 할");
        calculator.setResult(addNum, setNum);
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");

        // 값 제거
        System.out.println("가장 먼저 저장된 데이터를 삭제하기");
        calculator.removeResult(0);
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");
    }
}