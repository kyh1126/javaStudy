package _13_generic._1_whyGeneric;

import java.util.ArrayList;
import java.util.List;

// 제네릭: Java 5부터 제네릭 타입 추가. 잘못된 타입이 사용될 수 있는 문제를 컴파일 과정에서 제거할 수 있게 되었다.
//       타입 파라미터는 코드 작성 시 구체적인 타입으로 대체되어 다양한 코드를 생성하도록 해준다.
// 장점
// 1. 컴파일 시 강한 타입 체크를 할 수 있다.
// 2. 타입 변환(casting)을 제거한다: List 에 문자열 요소를 저장해도 요소 찾아올 때는 String 타입변환 해야하기 때문에 성능에 악영향을 미친다.
//                              제네릭 코드로 수정하면 저장되는 요소를 String 타입으로 국한하기 때문에 프로그램 성능이 향상된다.
public class GenericEx1 {
//    public static Map<Long, String> SHOP_MAP = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.add(2);
        // 타입 변환을 하지 않는다.
        System.out.println(list.get(0));
    }
}
