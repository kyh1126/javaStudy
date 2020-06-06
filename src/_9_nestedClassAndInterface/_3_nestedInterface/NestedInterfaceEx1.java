package _9_nestedClassAndInterface._3_nestedInterface;

// 중첩 인터페이스: 클래스의 멤버로 선언된 인터페이스.
// 인터페이스를 클래스 내부에 선언하는 이유: 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서.
public class NestedInterfaceEx1 {
    public static void main(String[] args) {
        Button btn = new Button();
        btn.setOnClickListener(new CallListener());
        btn.touch();
        // 어떤 구현 객체를 생성해서 Button 객체를 할당하느냐 따라 결과가 달라진다.
        btn.setOnClickListener(new MessageListener());
        btn.touch();
    }
}
