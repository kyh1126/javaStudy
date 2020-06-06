package _12_multiThread._1_multiThread;

// 스레드의 이름: 메인 스레드는 main 이라는 이름, 생성한 스레드는 자동적으로 Thread-n 이름으로 설정된다.
//             다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드로 변경하면 된다.
public class ThreadNameEx3 {
    public static void main(String[] args) {
        // 현재 thread 의 참조를 얻는다.
        Thread main = Thread.currentThread();
        System.out.println("프로그램 시작 스레드명: "+ main.getName());

        Thread a = new ThreadA();
        System.out.println("작업 스레드명: "+ a.getName());
        a.start();

        Thread b = new ThreadB();
        System.out.println("작업 스레드명: "+ b.getName());
        b.start();
    }
}
