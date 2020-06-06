package _12_multiThread._1_multiThread;

// 동시성: 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질
// 병렬성: 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질
// 스레드 갯수가 코어 수보다 많을 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정해야 하는데, 이를 스레드 스케줄링이라고 한다.
// 스레드 스케줄링에 의해 스레드들은 아주 짧은 시간에 번갈아가면서 그들의 run()메소드를 조금씩 실행한다.

// 자바의 스레드 스케줄링은 우선순위 방식과 순환 할당 방식을 사용한다.
// 우선순위(Priority) 방식: 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링 하는 것.
//                       스레드 객체에 우선순위 번호(1~10:가장 우선순위 높음)를 부여할 수 있기 때문에 개발자가 코드로 제어할 수 있다.
//                       우선순위를 부여하지 않으면 모든 스레드들은 기본적으로 5 할당. setPriority()로 우선순위 변경 가능.
// 순환 할당(Round-Robin) 방식: 시간 할당량(Time Slice)을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행하는 방식.
//                           JVM 에 의해서 정해지기 때문에 코드로 제어할 수 없다.
public class ThreadPriorityEx4 {
    public static void main(String[] args) throws InterruptedException {
        // 우선순위 방식
        for (int i = 10; i > 0; i--) {
            Thread thread = new CalcThread("thread" + i);
            if (i != 10) {
                thread.setPriority(Thread.MIN_PRIORITY);
            } else {
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            thread.start();
            Thread.sleep(2);
        }
    }
}
