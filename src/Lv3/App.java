package Lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);
    static Calculator calculator = new Calculator();

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
                System.out.println("양의 정수(0 포함)를 다시 입력하세요 ");
            } finally {
                scan.nextLine();
            }
        }
        return num;
    }

    // 사칙연산 기호 입력 받음
    public static char inputOperator() {
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

    // 연산 결과 출력
    public static void printResult(Calculator calculator) {
        System.out.println("처음에 넣은 값 : " + calculator.getResult(0));
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");

        // 값 추가
        System.out.println("새로운 값 추가하기");
        int addNum = inputNumber("추가 할");
        calculator.addResult(addNum);
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");

        // 값 변경
        System.out.println(addNum+"을 새로운 값으로 변경 ");
        int setNum = inputNumber("변경 할");
        calculator.setResult(addNum, setNum);
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");

        // 값 제거
        System.out.println("가장 먼저 저장된 데이터를 삭제하기");
        calculator.removeResult(0);
        System.out.println("전체 연산결과 : " + calculator.getResultList() +"\n");
    }

    public static void main(String[] args) {
        // ArithmeticCalculator 인스턴스 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
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
            int result =  arithmeticCalculator.calculate(num1, num2, operator);
            calculator.addResult(result);
            System.out.println("결과: "+num1 + " " + operator + " " + num2 + " = "+ result);

            // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(scan.nextLine().equals("exit")) {
                break;
            }
        }
        System.out.println("==================");
        // 연산 결과 출력
        printResult(calculator);

        System.out.println("=== 프로그램 종료 ===");
    }
}