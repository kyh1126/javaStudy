package _12_multiThread._7_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// 작업 생성: 하나의 작업은 Runnable 또는 Callable 구현 클래스로 표현. 차이점은 작업 처리 완료 후 리턴값이 있느냐 없느냐.
//          Runnable 의 run()메소드는 리턴값이 없고, Callable 의 call()메소드는 리턴값이 있다. 리턴 타입은 Callable<T>에서 지정한 T 타입이다.
//          스레드풀의 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 가져와 run()과 call()메소드를 실행한다.

// 작업 처리 요청: ExecutorService 의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위.
//              ExecutorService 는 작업 처리 요청을 위해 다음 2가지 종류의 메소드를 제공한다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명(매개 변수)                     설명
// -------------------------------------------------------------------------------
// void       execute(Runnable command)         Runnable 을 작업 큐에 저장. 작업 처리 결과를 받지 못함.
//                                              작업 처리 도중 예외가 발생하면 스레드가 종료되고 해당 스레드는 스레드풀에서 제거된다.
//                                              따라서 스레드풀은 다른 작업 처리를 위해 새로운 스레드를 생성한다.
// -------------------------------------------------------------------------------
// Future<?>  submit(Runnable task)             Runnable, Callable 을 작업 큐에 저장. 리턴된 Future 를 통해 작업 처리 결과를 얻을 수 있음.
// Future<V>  submit(Runnable task, V result)   작업 처리 도중 예외가 발생하더라도 스레드는 종료되지 않고 다음 작업을 위해 재사용된다.
// Future<V>  submit(Callable<V> task)          가급적이면 스레드 생성 오버헤드를 줄이기 위해 submit()을 사용하는 것이 좋다.
// -------------------------------------------------------------------------------
public class TaskCreateAndExecuteEx2 {
    public static void main(String[] args) throws InterruptedException {
        // 최대 스레드 개수가 2인 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            // 작업 정의
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                    try {
                        // 예외 발생 시킴
                        int value = Integer.parseInt("삼");
                    } catch (Exception e) {
                        System.out.println("익셉션낫따리 " + e.getMessage());
                        throw e;
                    }
                }
            };

            //작업 처리 요청

            // 실행 스레드 이름을 보면 모두 다른 스레드가 작업을 처리하고 있다.
            // 작업 처리 도중 예외가 발생했기 때문에 해당 스레드는 제거되고 새 스레드가 계속 생성되기 때문이다.
//            executorService.execute(runnable);
            // 예외가 발생하더라도 스레드가 종료되지 않고 계속 재사용되어 다른 작업을 처리한다.
            executorService.submit(runnable);

            // 콘솔에 출력 시간을 주기 위해 0.01초 일시 정지시킴
            Thread.sleep(10);
        }
        // 스레드풀 종료
        executorService.shutdown();
    }
}
