package Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 - ArrayList
    List<Integer> resultList = new ArrayList<>();

    // 사칙연산을 수행한 후, 결과값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator) {
        // 사칙연산
        int result;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else {
            // 예외처리 : 나눗셈에서 분모가 0이면 다시 입력받기
            if(num2 == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            result = num1 / num2;
        }
        //결과값 저장 및 반환
        resultList.add(result);
        return result;
    }
}