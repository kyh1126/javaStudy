package _11_basicAPIClass._6_class;

// Class 클래스: 자바는 클래스와 인터페이스의 메타 데이터(클래스 이름, 생성자 정보, 필드 정보, 메소드 정보)를 java.lang 패키지에 소속된
//             Class 클래스로 관리한다.

// Class 객체 얻기(getClass(), forName())
// 1. getClass(): 프로그램에서 Class 객체를 얻기 위한 Object 클래스 메소드. Object 는 모든 클래스의 최상위 클래스이므로 모든 클래스에서 호출 가능.
//                해당 클래스로 객체를 생성했을 때만 사용할 수 있다.
// 2. forName(): 객체를 생성하기 전에 직접 Class 객체를 얻을 수 있다. Class 는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들 수 없고, 정적
//               메소드인 forName()을 이용해야 한다. 클래스 전체 이름(패키지가 포함된)을 매개값으로 받고 Class 객체를 리턴한다.

public class ClassEx1 {
    public static void main(String[] args) {
        // 1
        String abc = new String("abc");
        Class clazz = abc.getClass();

        // 2
        try {
            Class clazz2 = Class.forName("_11_basicAPIClass._6_class.ClassEx1");
        } catch (ClassNotFoundException e) {
            // 매개값으로 주어진 클래스 못찾으면 예외 발생
        }
    }
}
