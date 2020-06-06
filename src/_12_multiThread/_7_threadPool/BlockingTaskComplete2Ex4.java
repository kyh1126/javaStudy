package _12_multiThread._7_threadPool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

// CompletionService: 스레드풀에서 작업 처리가 완료된 것만 통보받는 방법. 처리 완료된 작업을 가져오는 poll()과 take()메소드를 제공.
//                    객체를 생성할 때 생성자 매개값으로 ExecutorService 를 제공하면 된다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명(매개 변수)                     설명
// -------------------------------------------------------------------------------
// Future<V>    poll()                          완료된 작업의 Future 를 가져옴. 완료된 작업이 없다면 즉시 null 리턴.
// Future<V>    poll(long timeout,              완료된 작업의 Future 를 가져옴. 완료된 작업이 없다면 timeout 까지 블로킹됨.
//              TimeUnit unit)
// Future<V>    take()                          완료된 작업의 Future 를 가져옴. 완료된 작업이 없다면 있을 때까지 블로킹됨.
// Future<V>    submit(Callable<V> task)        스레드풀에 Callable 작업 처리 요청.
// Future<V>    submit(Runnable task, V result) 스레드풀에 Runnable 작업 처리 요청.
// -------------------------------------------------------------------------------
public class BlockingTaskComplete2Ex4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // 4. 작업 완료 순으로 통보:
        // 여러 작업들이 순차 처리될 필요성이 없고, 결과도 순차 이용할 필요가 없다면 작업 처리가 완료된 것부터 결과를 얻으면 된다.
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);

        System.out.println("[작업 처리 요청]");
        for (int i = 0; i < 3; i++) {
            // 스레드풀에게 작업 처리 요청
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int sum = 0;
                    for (int j = 0; j < 10; j++) {
                        sum += j;
                    }
                    return Thread.currentThread().getName();
                }
            });
        }

        System.out.println("[처리 완료된 작업 확인]");
        // 스레드풀의 스레드에서 실행하도록 함
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Instant starts = Instant.now();

                        // 완료된 작업 가져오기
                        Future<String> future = completionService.take();
                        System.out.println("[처리 결과] " + future.get() + " / " + Duration.between(starts, Instant.now()));

                    } catch (Exception e) {
                        break;
                    }
                }
                System.out.println("mine? " + Thread.currentThread().getName());
            }
        });

        Thread.getAllStackTraces().keySet().forEach(thread -> {
            System.out.println("Name: " + thread.getName() + (thread.isDaemon() ? "(데몬)" : "(주)"));
            System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
            System.out.println();
        });

        try {
            // 3초 후 스레드풀 종료
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        executorService.shutdownNow();
    }
}
