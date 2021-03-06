package _12_multiThread._4_controlThreadState;

// 1. 실행 대기
//      | ^ yield()
//   2. 실행  -stop()(deprecated)->  3. 종료
//      | sleep(), join(), wait(), suspend()(deprecated)
// 4. 일시 정지
//      | interrupt(), notify(), notifyAll(), resume()(deprecated)
// 1. 실행 대기
// -------------------------------------------------------------------------------
// 메소드                          설명
// -------------------------------------------------------------------------------
// interrupt()                  일시 정지 상태 스레드에서 interruptedException 발생시켜, 예외 처리 코드(catch)에서 실행 대기 상태/종료 상태로 갈 수 있도록 한다.
// -------------------------------------------------------------------------------
// notify()                     동기화 블록 내에서 wait() 메소드에 의해 일시 정지 상태에 있는 스레드를 실행 대기 상태로 만든다.
// notifyAll()
// -------------------------------------------------------------------------------
// resume()                     suspend() 메소드에 의해 일시 정지 상태에 있는 스레드를 실행 대기 상태로 만든다. - Deprecated. 이거 대신 notify(), notifyAll() 사용.
// -------------------------------------------------------------------------------
// sleep(long millis)           주어진 시간 동안 스레드를 일시 정지 상태로 만든다. 주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다.
// sleep(long millis, int nanos)
// -------------------------------------------------------------------------------
// join()                       join() 메소드를 호출한 스레드는 일시 정지 상태가 된다. 실행 대기 상태로 가려면, join() 메소드를 멤버로 가지는 스레드가 종료되거나,
// join(long millis)            매개값으로 주어진 시간이 지나야 한다.
// join(long millis, int nanos)
// -------------------------------------------------------------------------------
// wait()                       동기화(synchronized) 블록 내에서 스레드를 일시 정지 상태로 만든다. 매개값으로 주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다.
// wait(long millis)            시간이 주어지지 않으면 notify(), notifyAll() 메소드에 의해 실행 대기 상태로 갈 수 있다.
// wait(long millis, int nanos)
// -------------------------------------------------------------------------------
// suspend()                    스레드를 일시 정지 상태로 만든다. resume() 메소드를 호출하면 다시 실행 대기 상태가 된다. - Deprecated. 이거 대신 wait() 사용.
// -------------------------------------------------------------------------------
// yield()                      실행 중에 우선순위가 동일한 다른 스레드에게 실행을 양보하고 실행 대기 상태가 된다.
// -------------------------------------------------------------------------------
// stop()                       스레드를 즉시 종료시킨다. - Deprecated.
// -------------------------------------------------------------------------------

// wait(), notify(), notifyAll(): Object 클래스의 메소드.
public class ControlThreadStateEx1 {
}
