package _7_inheritance._3_finalAndProtected;

import _7_inheritance._1_inheritance.Phone;

// protected: 같은 패키지에서는 default 와 같이 접근 제한이 없지만 다른 패키지에서는 자식 클래스만 접근을 허용한다.
public class ProtectedEx2 {
    public static void main(String[] args) {
        Phone p = new NewPhone();
        p.bell();
    }
}
