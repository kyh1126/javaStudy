package _12_multiThread._4_controlThreadState;

public class PrintThread2 extends Thread {
    @Override
    public void run() {
//        try {
//            while (true) {
//                System.out.println("실행 중");
//                // InterruptedException 발생
//                Thread.sleep(1);
//            }
//        } catch (InterruptedException e) {
//        }

        while (true) {
            System.out.println("실행 중");
            if (this.isInterrupted() || Thread.interrupted()) {
                break;
            }
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
