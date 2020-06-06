package _12_multiThread._7_threadPool;

import java.nio.channels.CompletionHandler;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 콜백: 애플리케이션이 스레드에게 작업 처리를 요청한 후, 스레드가 작업을 완료하면 특정 메소드(콜백 메소드)를 자동 실행하는 기법.
// 콜백 방식의 작업 완료 통보:
// ExecutorService 는 콜백을 위한 별도의 기능을 제공하지 않지만 Runnable 구현 클래스를 작성할 때 콜백 기능을 구현할 수 있다.
// 먼저 콜백 메소드를 가진 클래스가 있어야 하는데, 직접 정의하거나 CompletionHandler 를 이용하면 된다.

// CompletionHandler: 이 인터페이스는 NIO 패키지에 포함되어 있는데 비동기 통신에서 콜백 객체를 만들 때 사용된다.
//                    completed()는 작업을 정상 처리 완료했을 때, failed()는 작업 처리 도중 예외가 발생했을 때 호출되는 콜백 메소드.
//                    2번째 매개값은 첨부값인데, 콜백 메소드에 결과값 이외의 추가적으로 전달하는 객체. 필요 없다면 Void 타입으로 지정.
public class CallbackTaskCompleteEx5 {
    private ExecutorService executorService;

    public CallbackTaskCompleteEx5() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    // 콜백 메소드를 가진 CompletionHandler 객체 생성
    private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {
        @Override
        public void completed(Integer result, Void attach) {
            System.out.println("completed() 실행: " + result);
        }

        @Override
        public void failed(Throwable throwable, Void attach) {
            System.out.println("failed() 실행: " + throwable.toString());
        }
    };

    public void doWork(final String x, final String y) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    int result = Integer.parseInt(x) + Integer.parseInt(y);
                    System.out.println("complete 찍어랏!");
                    callback.completed(result, null);
                } catch (NumberFormatException e) {
                    System.out.println("fail 찍어랏 30초후!");
                    try {
                        // interrupt 시켜서 다 실행시켜버리는구만...
                        Thread.sleep(30000);
                    } catch (Exception e1) {
                    }
                    callback.failed(e, null);
                }
            }
        };
        // 스레드풀에게 작업 처리 요청
        executorService.submit(task);
    }

    public List<Runnable> finish() {
        System.out.println("왔음둥 finish...");
        // 스레드풀 종료
        return executorService.shutdownNow();
    }

    public static void main(String[] args) {
        CallbackTaskCompleteEx5 ex = new CallbackTaskCompleteEx5();
        ex.doWork("3", "3");
        ex.doWork("3", "three");
        try {
            Thread.sleep(3000);
        } catch (Exception e1) {
        }
        System.out.println(ex.finish());
    }
}
