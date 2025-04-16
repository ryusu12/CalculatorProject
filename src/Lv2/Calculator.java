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
            result = num1 / num2;
        }
        //결과값 저장 및 반환
        resultList.add(result);
        return result;
    }
}