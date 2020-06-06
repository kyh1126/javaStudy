package _12_multiThread._7_threadPool;

import java.util.concurrent.*;

// 스레드풀: 병렬 작업 처리가 많아지면 스레드 개수가 증가되고 그에 따른 스레드 생성과 스케줄링으로 인해 CPU 가 바빠져 메모리 사용량이 늘어난다.
//         따라서 애플리케이션의 성능이 저하된다. 갑작스런 병렬 작업의 폭증으로 인한 스레드의 폭증을 막으려면 스레드풀을 사용해야 한다.
//         작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐에 들어오는 작업들을 하나씩 스레드가 맡아 처리한다.
//         작업 처리 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 작업한다. 그렇기 떄문에 작업 처리 요청이 폭증되어도 스레드의 전체 개수가 늘어나지
//         않으므로 애플리케이션의 성능이 급격히 저하되지 않는다.

// 자바는 스레드풀을 생성하고 사용할 수 있도록 java.util.concurrent 패키지에서 ExecutorService 인터페이스와 Executors 클래스를 제공하고 있다.
// Executors 의 다양한 정적 메소드를 이용해서 ExecutorService 구현 객체를 만들 수 있는데, 이것이 바로 스레드풀이다.

// 스레드풀 생성: ExecutorService 구현 객체는 Executors 클래스의 다음 2가지 메소드 중 하나를 이용해서 간편하게 생성할 수 있다.
// -------------------------------------------------------------------------------
// 메소드명(매개 변수)                  초기 스레드수     코어 스레드수     최대 스레드수
// -------------------------------------------------------------------------------
// newCachedThreadPool()            0               0           Integer.MAX_VALUE
// newFixedThreadPool(int nThreads) 0               nThreads    nThreads
// -------------------------------------------------------------------------------
// 초기 스레드수: ExecutorService 객체가 생성될 때 기본적으로 생성되는 스레드 수
// 코어 스레드수: 스레드 수가 증가된 후 사용되지 않는 스레드를 스레드풀에서 제거할 때 최소한 유지해야 할 스레드 수
// 최대 스레드수: 스레드풀에서 관리하는 최대 스레드 수
// 1. newCachedThreadPool: 초기 스레드 수와 코어 스레드 수는 0개이고, 스레드 개수보다 작업 개수가 많으면 새 스레드를 생성시켜 작업을 처리.
//                         이론적으로는 int 값이 가질 수 있는 최대값만큼 스레드가 추가되지만, OS 성능과 상황에 따라 달라진다.
//                         1개 이상의 스레드가 추가되었을 경우 60초 동안 추가된 스레드가 아무 작업을 하지 않으면 추가된 스레드를 종료하고 풀에서 제거.
// 2. newFixedThreadPool: 초기 스레드 수는 0개, 코어 스레드 수는 nThreads 이다. 스레드 개수보다 작업 개수가 많으면 새 스레드를 생성시켜 작업 처리.
//                        최대 스레드 개수는 매개값으로 준 nThreads. 이 스레드풀은 스레드가 작업을 처리하지 않고 놀고 있더라도 스레드 개수가 줄지 않는다.
// 3. ThreadPoolExecutor: 위의 메소드를 사용하지 않고 코어 스레드 개수와 최대 스레드 개수를 설정하고자 할 때.

// 스레드풀 종료: 스레드풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아있다.
//             main() 메소드 실행이 끝나도 애플리케이션 프로세스는 종료되지 않는다. 애플리케이션을 종료하려면 스레드풀을 종료시켜 스레드들이 종료 상태가
//             되도록 처리해줘야 한다. ExecutorService 는 종료 관련 다음 3가지 메소드를 제공하고 있다.
// -------------------------------------------------------------------------------
// 리턴 타입          메소드명(매개 변수)                   설명
// -------------------------------------------------------------------------------
// void             shutdown()                      현재 처리중인 작업뿐만 아니라 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀 종료
// List<Runnable>   shutdownNow()                   현재 작업 처리중인 스레드를 interrupt 해서 작업 중지를 시도하고 스레드풀을 종료시킨다.
//                                                  리턴값은 작업 큐에 있는 미처리 작업(Runnable) 목록이다.
// boolean          awaitTermination(               shutdown() 메소드 호출 이후, 모든 작업 처리를 timeout 시간 내에 완료하면 true 리턴,
//                  long timeout, TimeUnit unit)    완료하지 못하면 작업 처리중인 스레드를 interrupt 하고 false 리턴한다.
// -------------------------------------------------------------------------------
// 남아있는 작업 마무리하고 스레드풀 종료할 때에는 shutdown() 을 일반적으로 호출, 남아있는 작업 상관없이 강제 종료할 때에는 shutdownNow() 호출.
public class ThreadPoolEx1 {
    public static void main(String[] args) {
        // 1
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors());
        // 2: CPU 코어의 수만큼 최대 스레드를 사용하는 스레드풀을 생성.
        ExecutorService executorService1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // 3
        ExecutorService executorService2 = new ThreadPoolExecutor(
                3,                      // 코어 스레드수
                100,                // 최대 스레드수
                120L,                  // 놀고 있는 시간
                TimeUnit.SECONDS,                   // 놀고 있는 시간 단위
                new SynchronousQueue<Runnable>()    // 작업 큐
        );

        // 1
        executorService.shutdown();
        // 2
        executorService.shutdownNow();
    }
}
