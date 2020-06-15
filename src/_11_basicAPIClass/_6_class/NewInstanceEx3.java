package _11_basicAPIClass._6_class;

// 동적 객체 생성(newInstance()): Class 객체를 이용하면 new 연산자를 사용하지 않아도 동적으로 객체를 생성할 수 있다. 이 방법은 코드 작성 시에
//                            클래스 이름을 결정할 수 없고, 런타임 시에 클래스 이름이 결정되는 경우에 매우 유용하게 사용된다. 기본 생성자를
//                            호출해서 객체를 생성하기 때문에 반드시 클래스에 기본 생성자가 존재해야 한다. 만약 매개 변수가 있는 생성자를 호출하고
//                            싶다면 리플렉션으로 Constructor 객체를 얻어 newInstance()메소드를 호출하면 된다.
//                            해당 클래스가 추상 클래스이거나 인터페이스일 경우, 또는 클래스나 생성자가 접근 제한자로 인해 접근할 수 없을 경우에
//                            예외 발생한다.

public class NewInstanceEx3 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("런타임 시 결정되는 클래스 이름");
            Object obj = clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }
    }
}
