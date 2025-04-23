package Lv3;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        System.out.println("=== 계산기 프로그램 ===");
        while (true) {
            CheckInput checkInput = new CheckInput();
            // 1. 피연산자와 사칙연산를 입력받습니다.
            BigDecimal num1 = checkInput.inputNumber("첫 번째");
            BigDecimal num2 = checkInput.inputNumber("두 번째");
            OperatorType operator = checkInput.inputOperator();

            // 예외처리 : 나눗셈에서 분모가 0이면 처음부터 입력받습니다.
            if (num2.compareTo(BigDecimal.ZERO) == 0 && operator == OperatorType.DIVIDE) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            // 2. 연산 진행
            BigDecimal result = calculator.calculate(num1, num2, operator);

            // 3. 연산 결과 출력
            System.out.println("\n결과: " + num1.toPlainString() + " " + operator.getOperator() + " " + num2.toPlainString() + " = " + result.toPlainString());
            calculator.printResultList();

            // 3.1. 저장된 연산 결과들 중, 입력받은 값보다 큰 결과값들을 출력
            calculator.printHighResultList(result);
            System.out.println("==================");

            // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.
            if (app.showOptions(calculator)) break;
        }
        System.out.println("=== 프로그램 종료 ===");
    }

    // 연산 후 작업
    // 상황에 따라 값 확인, 추가, 변경, 제거를 진행합니다.
    private boolean showOptions(ArithmeticCalculator calculator) {
        CheckInput checkInput = new CheckInput();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("더 계산하시겠습니까? (exit: 종료 / 그 외: 계속 계산하기)");
            System.out.println("추가 기능: (show: 결과 확인하기 / set: 결과 변경하기 / remove: 결과 삭제하기 / first: 가장 먼저 저장된 결과 삭제하기)");
            String userInput = scan.nextLine();
            switch (userInput) {
                case "exit": {
                    return true;
                }
                case "show": {
                    calculator.printResultList();
                    break;
                }
                case "set": {
                    BigDecimal changeNum = checkInput.inputNumber("변경 할");
                    BigDecimal setNum = checkInput.inputNumber("새로 들어갈");
                    calculator.setResult(changeNum, setNum);
                    calculator.printResultList();
                    break;
                }
                case "remove": {
                    BigDecimal deleteNum = checkInput.inputNumber("삭제 할");
                    calculator.removeResult(deleteNum);
                    calculator.printResultList();
                    break;
                }
                case "first": {
                    calculator.removeFirstResult();
                    calculator.printResultList();
                    break;
                }
                default:
                    return false;
            }
        }
    }
}