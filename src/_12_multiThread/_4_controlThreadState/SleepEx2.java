package _12_multiThread._4_controlThreadState;

// sleep: Thread 클래스의 정적 메소드. 실행 중인 스레드를 일정 시간 멈추게 한다.
//        주어진 시간 동안 일시 정지 상태가 되고, 다시 실행 대기 상태로 돌아간다.
public class SleepEx2 {
    public static void main(String[] args) {
        try {
            // 1초
            Thread.sleep(1000);
        } catch (InterruptedException e) { // interrupt() 메소드가 호출되면 실행.
        }
    }
}
