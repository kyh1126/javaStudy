package _7_inheritance._2_methodOverride;

import _7_inheritance._1_inheritance.DmbPhone;
import _7_inheritance._1_inheritance.Phone;

// 메소드 오버라이딩: 상속된 메소드의 내용을 자식 클래스에서 재정의하는 것. 메소드가 오버라이딩되면 부모 객체의 메소드는 숨겨진다.
// 1. 부모의 메소드와 동일한 시그너처(리턴 타입, 메소드 이름, 매개 변수 리스트)를 가져야 한다.
// 2. 접근 제한을 더 강하게 오버라이딩할 수 없다. 반대는 가능하다.(부모 메소드가 default 면, 자식 메소드는 default/public 접근 제한을 가질 수 있다.)
// 3. 새로운 예외(Exception)를 throws 할 수 없다.

// 자식 클래스 내부에서 오버라이딩된 부모 클래스의 메소드를 호출해야 하는 상황이 발생하면 super 키워드를 붙여 호출할 수 있다. super.메소드()
public class MethodOverrideEx1 {
    public static void main(String[] args) {
        Phone phone = new DmbPhone("name", "pink", 20);
        phone.bell();
    }
}
