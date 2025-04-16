package Lv2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 계산기 프로그램 ===");
        Calculator calculator = new Calculator();
        int result =  calculator.calculate(4, 2, '*');
        System.out.println("결과: " + result);
        System.out.println("연산결과가 저장된 컬렉션: " + calculator.resultList);
    }
}