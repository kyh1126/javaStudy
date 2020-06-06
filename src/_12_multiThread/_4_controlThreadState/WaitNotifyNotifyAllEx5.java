package _12_multiThread._4_controlThreadState;

// 경우에 따라서는 두 개의 스레드를 교대로 번갈아가며 실행해야 할 경우가 있다.
// 정확한 교대 작업이 필요할 경우, 자신의 작업이 끝나면 상대방 스레드를 일시 정지 상태에서 풀어주고, 자신은 일시 정지 상태로 만드는 것이다.
// 이 방법의 핵심은 공유 객체에 있다. 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 구분해 놓는다.
// 한 스레드가 작업을 완료하면 notify() 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고, 자신은 wait() 호출하여 일시 정지 상태로 만든다.

// wait: 일시 정지 상태로 만든다.
// notify: wait()에 의해 일시 정지된 스레드 중 하나를 실행 대기 상태로 만든다.
// notifyAll: wait()에 의해 일시 정지된 모든 스레드들을 실행 대기 상태로 만든다.
// 이 메소드들은 Object 클래스의 메소드이므로 모든 공유 객체에서 호출 가능하다. 주의할 점은 동기화 메소드 또는 동기화 블록 내에서만 사용할 수 있다.
public class WaitNotifyNotifyAllEx5 {
    public static void main(String[] args) {
        WorkObject shared = new WorkObject();

        ThreadA2 a = new ThreadA2(shared);
        ThreadB2 b = new ThreadB2(shared);

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
        }
        System.out.println("the end!");
    }
}
