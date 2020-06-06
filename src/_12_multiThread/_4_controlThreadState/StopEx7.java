package _12_multiThread._4_controlThreadState;

// stop: 이 메소드는 deprecated 되었다. stop()메소드로 스레드를 갑자기 종료하게 되면 스레드가 사용중이던 자원들이 불안전한 상태로 남겨지기 때문이다.
//       자원이란 파일, 네트워크 연결 등. 이 메소드 대신 스레드를 즉시 종료시키려면 stop 플래그를 이용해라.
public class StopEx7 {
    public static void main(String[] args) {
        PrintThread1 printThread = new PrintThread1();
        printThread.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        printThread.setStop(true);
    }
}
