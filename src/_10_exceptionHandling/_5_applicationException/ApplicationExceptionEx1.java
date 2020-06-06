package _10_exceptionHandling._5_applicationException;

// 애플리케이션 예외: 사용자 정의 예외 클래스는 컴파일러가 체크하는 일반 예외로 선언할 수도 있고, 컴파일러가 체크하지 않는 실행 예외로 선언할 수도 있다.
//                일반 예외일 경우 Exception 을 상속하면 되고, 실행 예외일 경우 RuntimeException 상속하면 된다.
//                메소드 선언들을 포함할 수 있지만 대부분 생성자 선언만을 포함한다. 생성자는 2개를 선언하는 것이 일반적인데, 하나는 기본 생성자이고,
//                다른 하나는 예외 메세지를 전달하기 위한 생성자이다. 이 생성자는 상위 클래스의 생성자를 호출하여 예외 메시지를 넘겨준다.
//                예외 메시지의 용도는 catch 블록의 예외 처리 코드에서 이용하기 위해서다.
public class ApplicationExceptionEx1 {
    public static void main(String[] args) {
        Account account = new Account();
        try {
            account.withdraw(300);
        } catch (BalanceInsufficientException e) {
            e.printStackTrace();
        }
    }
}
