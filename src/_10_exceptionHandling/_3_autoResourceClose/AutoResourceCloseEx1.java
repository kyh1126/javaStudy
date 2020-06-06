package _10_exceptionHandling._3_autoResourceClose;

// 자동 리소스 닫기: 자바7에 추가된 try-with-resources. 예외 발생 여부 상관없이 사용했던 리소스 객체(각종 입출력 스트림, 서버 소켓, 소켓, 각종 채녈)
//               close() 메소드를 호출해서 안전하게 리소스를 닫아준다. 리소스란 데이터를 읽고 쓰는 객체.
public class AutoResourceCloseEx1 {
    public static void main(String[] args) {
        // finally 로 close() 메소드 써주던거와 같다. 예외가 발생하면 자동으로 close() 메소드가 호출된다. 우선 리소스를 닫고 catch 블록을 실행한다.
        // 예외 발생 안하더라도 close() 마지막에 호출해준다. 리소스 객체는 AutoCloseable 인터페이스를 구현하고 있어야 한다.
        try (
                FileInputStream fis = new FileInputStream("file.txt");
                FileInputStream fis2 = new FileInputStream("file2.txt");
        ) {
            fis.read();
            // 새로운 예외를 발생시킨다.
            throw new Exception();
        } catch (Exception e) {
            System.out.println("예외 처리 코드가 실행되었다.");
        }
    }
}
