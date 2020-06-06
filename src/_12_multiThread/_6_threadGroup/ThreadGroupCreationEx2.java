package _12_multiThread._6_threadGroup;

// 스레드 그룹 생성: ThreadGroup 이름만 주거나, 부모 ThreadGroup 과 이름을 매개값으로 줄 수 있다.
//               스레드 그룹 생성시 부모 스레드 그룹을 지정하지 않으면 현재 스레드가 속한 그룹의 하위 그룹으로 생성된다.
//               새로운 스레드 그룹을 생성한 후, 이 그룹에 스레드를 포함시키려면 Thread 객체를 생성할 때 생성자 매개값으로 스레드 그룹을 지정하면 된다.
public class ThreadGroupCreationEx2 {
    public static void main(String[] args) {
        // 명시적으로 스레드 그룹 만들기
        ThreadGroup tg = new ThreadGroup("스레드그룹1");
        ThreadGroup tg2 = new ThreadGroup(Thread.currentThread().getThreadGroup(), "스레드그룹2");

        // 스레드 그룹을 매개값으로 갖는 Thread 생성자 4가지
        // Runnable 타입 객체, 스레드의 이름, JVM 이 이 스레드에 할당할 stack size.
        Thread t1 = new Thread(tg, new Runnable() {@Override public void run() {}});
        Thread t2 = new Thread(tg, new Runnable() {@Override public void run() {}}, "이름");
        Thread t3 = new Thread(tg, new Runnable() {@Override public void run() {}}, "이름", 10L);
        Thread t4 = new Thread(tg, "이름");
    }
}