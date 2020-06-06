package _6_class._4_finalAndConstant;

// final: 초기값이 저장되면 프로그램 실행 도중에 수정할 수 없다. 필드 선언시 주거나 생성자에서 주는 방법이 있다.
//        생성자는 final 필드의 최종 초기화를 마쳐야 하는데, 만약 초기화되지 않은 final 필드를 그대로 남겨두면 컴파일 에러가 발생한다.
public class FinalEx1 {
    public static void main(String[] args) {
        Person p = new Person("123-456", "사람");
        p.name = "사람아님";
//        p.ssn = "111";  // final 필드는 값 수정 불가
    }
}
