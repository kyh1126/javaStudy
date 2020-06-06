package _12_multiThread._1_multiThread;

import java.awt.*;

// 모든 자바 애플리케이션은 메인 스레드(main thread)가 main() 메소드를 실행하면서 시작된다.
// 메인 스레드는 필요에 따라 작업 스레드들을 만들어서 병렬로 코드를 실행할 수 있다.(멀티 스레드로 멀티 태스킹 수행)
// 메인 스레드가 작업 스레드보다 먼저 종료되더라도 작업 스레드가 계속 실행중이라면 프로세스는 종료되지 않는다.

// 자바에서는 작업 스레드도 객체로 생성되기 때문에 클래스가 필요하다.
// java.lang.Thread 클래스를 직접 객체화해서 생성해도 되지만, Thread 를 상속해서 하위 클래스를 만들어 생성할 수도 있다.
// 1. Thread 클래스로부터 작업 스레드 객체를 직접 생성: Runnable 을 매개값으로 갖는 생성자를 호출.

// Runnable: 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체라고 해서 붙여진 이름.
//           구현 클래스는 run()을 재정의해서 작업 스레드가 실행할 코드를 작성해야 한다. 작업 내용을 가지고 있는 객체이지 실제 스레드는 아니다.
//           Runnable 구현 객체를 생성한 후, 이를 매개값으로 해서 Thread 생성자를 호출하면 비로소 작업 스레드가 생성된다.

// 작업 스레드는 생성되는 즉시 실행되는 것이 아니라, start() 메소드를 호출해야만 비로소 실행된다.
// start(): 작업 스레드는 매개값으로 받은 Runnable 의 run() 메소드를 실행하면서 자신의 작업을 처리한다.

// 2. Thread 하위 클래스로부터 생성: 작업 스레드가 실행할 작업을 Runnable 로 만들지 않고, Thread 의 하위 클래스로 작업 스레드를 정의하면서 작업 내용 포함시키기.
//                             Thread 클래스 상속한 후 run 메소드를 재정의해서 스레드가 실행할 코드를 작성한다.
//                             작업 스레드 클래스로부터 작업 스레드 객체를 생성하는 방법은 일반적인 객체를 생성하는 방법과 동일하다.
public class MainThreadEx2 {
    public static void main(String[] args) {
        // 1
        Thread thread = new Thread(() -> { // 스레드가 실행할 코드; (람다식): 자바 8부터 지원.
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() { // 위랑 동일; (익명 구현 객체)
            }
        });
        thread1.start();

        Runnable beepTask = new BeepTask();
        Thread thread2 = new Thread(beepTask);
        thread2.start();

        new Thread(() -> {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 5; i++) {
                toolkit.beep();
                try {
                    Thread.sleep(900);
                } catch (Exception e) {
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵~");
            try {
                Thread.sleep(500);  // 0.5초간 일시 정지
            } catch (Exception e) {
            }
        }

        // 2
        Thread thread3 = new BeepThread();
        thread3.start();

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }
            }
        };

    }
}
