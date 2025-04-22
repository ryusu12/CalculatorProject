package Lv3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculator <T extends BigDecimal>{
    // 연산 결과를 저장하는 컬렉션 - ArrayList
    private final List<T> resultList = new ArrayList<>();

    /* Getter 메서드 구현 */
    // 전체 연산 결과 확인
    public List<T> getResultList() {
        return resultList;
    }

    /* Setter 메서드 구현 */
    // 특정 값 추가
    public void addResult(T num) {
        resultList.add(num);
    }

    // 특정 값 변경 : 특정 값의 위치 확인 후 수정
    public void setResult(T num, T setNum) {
        int index = resultList.indexOf(num);
        try {
            resultList.set(index, setNum);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("변경할 값이 없습니다.");
        }
    }

    // 특정 값 삭제 : 특정 값의 위치 확인 후 삭제
    public void removeResult(T num) {
        int index = resultList.indexOf(num);
        try {
            resultList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 값이 없습니다.");
        }
    }

    // 특정 값 삭제 : index로 삭제
    public void removeFirstResult() {
        try {
            resultList.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 값이 없습니다.");
        }
    }
}