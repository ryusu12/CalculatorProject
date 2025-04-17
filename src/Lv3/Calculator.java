package Lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 - ArrayList
    private final List<Integer> resultList = new ArrayList<>();

    /* Getter 메서드 구현 */
    // 전체 연산 결과 확인
    public List<Integer> getResultList() {
        return resultList;
    }

    // 특정 연산 결과 확인
    public int getResult(int num) {
        return resultList.get(num);
    }

    /* Setter 메서드 구현 */
    // 특정 값 추가
    public void addResult(int num) {
        resultList.add(num);
    }

    // 특정 값 변경 : 특정 값의 위치 확인 후 수정
    public void setResult(int num, int setNum) {
        int index = resultList.indexOf(num);
        resultList.set(index, setNum);
    }

    // 특정 위치 값 삭제
    public void removeResult(int num) {
        resultList.remove(num);
    }
}