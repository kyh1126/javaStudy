package _7_inheritance._3_finalAndProtected;

import _7_inheritance._1_inheritance.Phone;

public class NewPhone extends Phone {
    public NewPhone() {
        super();
        // new 연산자를 사용해서 생성자를 직접 호출할 수는 없고, 자식 생성자에서 super() 로 생성자를 호출할 수 있다.
//        new Phone();
    }
}
