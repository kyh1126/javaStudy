package _13_generic._1_whyGeneric;

// 제네릭 타입: 타입을 파라미터로 가지는 클래스와 인터페이스. 타입 파라미터는 변수명과 동일한 규칙에 따라 작성할 수 있지만,
//           일반적으로 대문자 알파벳 한 글자로 표현한다.

// Object 타입을 사용하면 모든 종류의 자바 객체를 저장할 수 있긴 하지만,
// 저장할 때 자동 타입 변환이 발생하고, 읽어올 떄에도 타입 변환이 발생한다. 성능에 좋지 못하다.
public class GenericTypeEx2 {
    public static void main(String[] args) {
        Box<String> strBox = new Box();
        strBox.setT("aa");

        Box<Integer> intBox = new Box<>();
        intBox.setT(1);

    }
}
