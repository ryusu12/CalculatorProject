package Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 - ArrayList
    private final List<Integer> resultList = new ArrayList<>();

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

    /* Getter 메서드 구현 */
    // 전체 연산 결과 확인
    public List<Integer> getResultList() {
        return resultList;
    }

    /* Setter 메서드 구현 */
    // 특정 값 변경 : 특정 값의 위치 확인 후 수정
    public void setResult(int num, int setNum) {
        int index = resultList.indexOf(num);
        try {
            resultList.set(index, setNum);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("변경할 값이 없습니다.");
        }
    }

    // 특정 값 삭제 : 특정 값의 위치 확인 후 삭제
    public void removeResult(int num) {
        int index = resultList.indexOf(num);
        try {
            resultList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 값이 없습니다.");
        }
    }

    // 가장 먼저 저장된 데이터 삭제
    public void removeFirstResult() {
        try {
            resultList.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 값이 없습니다.");
        }
    }
}