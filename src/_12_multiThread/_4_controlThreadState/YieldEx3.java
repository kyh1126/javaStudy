package _12_multiThread._4_controlThreadState;

// yield: 다른 스레드에게 실행 양보. yield() 메소드를 호출한 스레드는 실행 대기 상태로 돌아가고 동일 우선순위/높은 우선순위 다른 스레드가 실행 기회를 가질 수 있도록 해준다.
public class YieldEx3 {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        a.work = false;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        a.work = true;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        a.stop = true;
        b.stop = true;
    }
}
