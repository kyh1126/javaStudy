package _10_exceptionHandling._4_throws;

// throws: 처리하지 않은 예외를 호출한 곳으로 떠넘긴다. 이러한 메소드는 반드시 try 안에서 호출되어야 한다.
//         catch 에서 해당 예외를 잡아줘야 한다.
public class ThrowsEx1 {
    public static void main(String[] args) {
        try {
            findClass("java.lang.String2");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        }
    }

    // throws 뒤에는 떠넘길 예외 클래스를 쉼표로 구분해서 나열해준다.
    private static void findClass(String name) throws ClassNotFoundException {
        Class clazz = Class.forName(name);
    }
}
