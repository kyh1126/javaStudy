package _10_exceptionHandling._1_exception;

// 예외 처리 코드: try-catch-finally 블록은 생성자 내부와 메소드 내부에서 작성되어 일반 예외와 실행 예외가 발생할 경우 예외 처리 가능하다.
//              try 가 정상 실행되면 finally 블록 실행한다. finally 는 예외 발생 여부와 상관없이 항상 실행한다. try 에서 return 되도 실행.
public class ExceptionHandlingEx3 {
    public static void main(String[] args) {
        try {
            // 클래스가 존재하면 Class 객체 리턴, 아니면 ClassNotFoundException.
            Class clazz = Class.forName("java.lang.Integer");
            System.out.println(clazz.getSimpleName());

            Class clazz2 = Class.forName("java.lang.Integer2");
        } catch (ClassNotFoundException e) {
            System.out.println("IDE 에서 이렇게 잡아준다.");
        }
    }
}
