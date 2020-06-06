package _10_exceptionHandling._5_applicationException;

// 예외 정보 얻기: 모든 예외 객체는 Exception 클래스를 상속하기 떄문에 Exception 메소드들을 모든 예외 객체에서 호출할 수 있다.
//              그 중 가장 많이 사용되는 메소드는 getMessage()와 printStackTrace()이다.
public class ExceptionInfoEx2 {
    public static void main(String[] args) {
        Account account = new Account();
        try {
            try {
                if (3 > 2) return;
            } finally {
                System.out.println("finally?");
            }

            account.withdraw(300);
        } catch (BalanceInsufficientException e) {
            // 예외가 가지고 있는 Message 얻기
            System.out.println(e.getMessage());
            // 예외 발생 경로를 추적.
            e.printStackTrace();
        }
    }
}
