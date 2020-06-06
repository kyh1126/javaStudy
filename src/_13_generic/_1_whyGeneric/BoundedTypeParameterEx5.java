package _13_generic._1_whyGeneric;

// 제한된 타입 파라미터: 타입 파라미터 뒤에 extends 키워드를 붙이고 상위 타입을 명시하면 된다. 상위 타입은 인터페이스도 가능하다. 인터페이스도 extends.
//                  타입 파라미터에 지정되는 구체적인 타입은 상위 타입이거나 그 하위 또는 구현 클래스만 가능하다. 주의할 점은 메소드의 중괄호 안에서
//                  타입 파라미터 변수로 사용 가능한 것은 상위 타입의 멤버(필드, 메소드)로 제한된다.
public class BoundedTypeParameterEx5 {
    public static void main(String[] args) {
        // int -> Integer 로 자동 boxing.
        int result1 = Util.compare(10, 20);
        // double -> Double 로 자동 boxing.
        int result2 = Util.compare(4.5, 20);
    }
}
