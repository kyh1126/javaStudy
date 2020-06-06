package _12_multiThread._7_threadPool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Future: 작업 결과가 아니라 작업이 완료될 때까지 기다렸다가(지연했다가=블로킹되었다가) 최종 결과를 얻는데 사용됨. 지연 완료(pending completion) 객체.
// Future 가 갖고있는 get() 메소드
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명(매개 변수)                 설명
// -------------------------------------------------------------------------------
// V        get()                            작업이 완료될 때까지 블로킹되었다가 처리 결과 V를 리턴
// V        get(long timeout, TimeUnit unit) timeout 전에 작업이 완료되면 결과 V를 리턴하지만, 완료되지 않으면 TimeoutException 발생시킴.
// -------------------------------------------------------------------------------

// -------------------------------------------------------------------------------
// 메소드                                  작업 처리 완료 후 리턴 타입          작업 처리 도중 예외 발생
// -------------------------------------------------------------------------------
// submit(Runnable task)                 future.get() -> null           future.get() -> 예외 발생
// submit(Runnable task, Integer result) future.get() -> int 타입 값      future.get() -> 예외 발생
// submit(Callable<String> task)         future.get() -> String 타입 값   future.get() -> 예외 발생
// -------------------------------------------------------------------------------

// 블로킹 방식의 작업 완료 통보:
// Future 의 get()메소드 호출하면 스레드가 작업을 완료할 때까지 블로킹되었다가 작업 완료하면 처리 결과를 리턴한다.
// 스레드가 작업을 완료하기 전까지는 get()메소드가 블로킹되므로 다른 코드를 실행할 수 없다.
// 그렇기 때문에 get()메소드를 호출하는 스레드는 새로운 스레드거나 스레드풀의 또 다른 스레드가 되어야 한다.

// Future 가 갖고있는 다른 메소드
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명(매개 변수)                         설명
// -------------------------------------------------------------------------------
// boolean  cancel(boolean mayInterruptIfRunning)   작업 처리가 진행 중일 경우 취소시킴. 작업 시작전이면 매개값 관계없이 작업 취소 후 true 리턴,
//                                                  진행중이면 매개값 true 일때만 작업 스레드를 interrupt 한다.
//                                                  작업이 완료 되었거나 어떤 이유로 취소될 수 없다면 false 리턴한다.
// boolean  isCancelled()                           작업이 취소되었는지 여부. 작업이 완료되기 전 작업이 취소되었을 경우에만 true 리턴.
// boolean  isDone()                                작업 처리가 완료되었는지 여부. 작업이 정상적, 예외, 취소 등 어떤 이유건 완료되면 true 리턴.
// -------------------------------------------------------------------------------

// newScheduledThreadPool 사용 빈, Executor 구현 ThreadPoolTaskExecutor, AtomicInteger CompletableFuture ConcurrentHashMap...;
public class BlockingTaskCompleteEx3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // 1. 리턴값이 없는 작업 완료 통보:
        // 리턴값이 없는 작업일 경우 Runnable 객체로 생성하면 된다. 결과값이 없는 작업 처리 요청은 submit(Runnable task) 메소드.
        // 결과값이 없음에도 Future 객체를 리턴하는데, 이는 스레드가 작업 처리를 정상적으로 완료했는지, 작업 처리 도중 예외가 발생했는지 확인용이다.
        // 작업 처리가 정상 완료되면 Future.get() null 리턴, 작업 처리 도중 interrupt 되면 InterruptedException, 예외 발생하면 ExecutionException 발생.
        System.out.println("[작업 처리 요청]");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                System.out.println("[처리 결과] " + sum);
                Instant start = Instant.now();
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
                System.out.println("time :: " + Duration.between(start, Instant.now()));
            }
        };
        Future future = executorService.submit(runnable);
        try {
            Instant start = Instant.now();
            System.out.println("start future!");
            future.get();
            System.out.println("end future!" + Duration.between(start, Instant.now()));
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }

        // 2. 리턴값이 있는 작업 완료 통보:
        // 스레드풀의 스레드가 작업 완료 후 애플리케이션이 처리 결과를 얻어야 된다면 작업 객체를 Callable 로 생성하면 된다.
        // 스레드 풀의 스레드가 Callable 객체의 call()메소드를 모두 실행하고 T 타입의 값을 리턴하면,
        // Future<T>의 get()메소드는 블로킹이 해제되고 T 타입의 값을 리턴하게 된다.
        System.out.println("[작업 처리 요청]");
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        Future<Integer> futureInt = executorService.submit(task);
        try {
            int sum = futureInt.get();
            System.out.println("[처리 결과] " + sum);
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }

        // 3. 작업 처리 결과를 외부 객체에 저장:
        // 스레드가 작업 처리를 완료하고 외부 Result 객체에 작업 결과를 저장하면, 애플리케이션이 Result 객체를 사용해서 어떤 작업을 진행할 수 있다.
        // 대개 Result 객체는 공유 객체가 되어, 2개 이상의 스레드 작업을 취합할 목적으로 이용된다. Future 의 get()메소드를 호출하면 스레드가
        // 작업을 완료할 때까지 블로킹되었다가 작업을 완료하면 V타입 객체를 리턴한다. 차이점은 스레드 처리 결과가 내부에 저장되어 있다는 것이다.
        // 작업 객체는 Runnable 구현 클래스로 생성하는데, 주의할 점은 스레드에서 결과를 저장하기 위해 외부 Result 객체를 사용해야 하므로 생성자를 통해
        // Result 객체를 주입받도록 해야한다.
        System.out.println("[작업 처리 요청]");
        // 작업 정의
        class Task implements Runnable {
            Result result;

            Task(Result result) {
                this.result = result;
            }

            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                result.addValue(sum);
            }
        }

        Result result = new Result();
        Runnable task1 = new Task(result);
        Runnable task2 = new Task(result);
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);

        try {
            result = future1.get();
            result = future2.get();
            System.out.println("[처리 결과] " + result.accumVal);
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }

        executorService.shutdown();
    }
}

// 처리 결과를 저장하는 클래스
class Result {
    int accumVal;

    synchronized void addValue(int val) {
        accumVal += val;
    }

}