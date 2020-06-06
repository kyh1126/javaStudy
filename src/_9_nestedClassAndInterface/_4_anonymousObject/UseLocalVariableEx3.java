package _9_nestedClassAndInterface._4_anonymousObject;

// 익명 객체의 로컬 변수 사용: 익명 객체 내부에서 메소드의 매개 변수나 로컬 변수를 사용할 경우, 이 변수들은 final 특성을 가져야 한다.
//                       자바 7 이전까지는 반드시 final 키워드로 이 변수들을 선언해야 했지만, 자바 8 이후부터는 final 키워드 없이 선언해도 좋다.
//                       선언 없이도 final 특성을 갖기 때문이다. 컴파일 시 final 키워드가 있으면 메소드 내부에 지역 변수로 복사되지만,
//                       없다면 익명 클래스의 필드로 복사된다.
public class UseLocalVariableEx3 {
    public static void main(String[] args) {
        Anonymous3 a = new Anonymous3();
        a.method(1, 2);
    }
}
