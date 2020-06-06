package _12_multiThread._4_controlThreadState;

// 스레드는 다른 스레드와 독립적으로 실행하는 것이 기본이지만 다른 스레드가 종료될 때까지 기다렸다가 실행해야 하는 경우가 발생할 수도 있다.
// join: 예를 들어 계산 작업을 하는 스레드가 모든 계산 작업을 마쳤을 때, 계산 결과값을 받아 이용하는 경우.
public class JoinEx4 {
    public static void main(String[] args) {
        SumThread thread = new SumThread();
        thread.start();

        try {
            // sum thread 가 종료할 때까지 메인 스레드를 일시 정지시킴.
            thread.join();
        } catch (InterruptedException e) {
        }

        System.out.println("1~100 합: " + thread.getSum());
    }
}
