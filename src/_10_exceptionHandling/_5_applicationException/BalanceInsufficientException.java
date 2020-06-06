package _10_exceptionHandling._5_applicationException;

// Exception 을 상속하기 때문에 컴파일러에 의해 체크되는 예외가 된다.
public class BalanceInsufficientException extends Exception {
    public BalanceInsufficientException() {
    }

    // 메세지를 갖는 생성자를 이용하였다면, 메시지는 자동적으로 예외 객체 내부에 저장된다.
    public BalanceInsufficientException(String message) {
        super(message);
    }
}
