package _12_multiThread._4_controlThreadState;

// interrupt: 스레드가 일시 정지 상태에 있을 때 InterruptedException 를 발생시키는 역할을 한다. run()메소드를 정상 종료시킬 수 있다.
//            스레드가 실행 대기/실행 상태일 땐 예외가 발생하지 않고, 스레드가 미래에 일시 정지 상태가 되면 예외가 발생한다.
//            따라서 스레드가 일시 정지 상태가 되지 않으면 interrupt() 메소드 호출은 아무런 의미가 없다.

// interrupt() 메소드가 호출되었다면 스레드의 interrupted() 와 isInterrupted() 메소드는 true 를 리턴.
// 1. interrupted: 정적 메소드. 현재 스레드가 interrupted 되었는지 확인.
// 2. isInterrupted: 인스턴스 메소드. 현재 스레드가 interrupted 되었는지 확인.
public class InterruptEx8 {
    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        thread.interrupt();
    }
}
