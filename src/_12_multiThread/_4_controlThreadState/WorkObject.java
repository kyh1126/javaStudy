package _12_multiThread._4_controlThreadState;

public class WorkObject {
    public synchronized void methodA() {
        System.out.println("ThreadA의 methodA() 작업 실행");
        // 일시 정지 상태에 있는 ThreadB 를 실행 대기 상태로 만듬
        notify();
        try {
            // ThreadA를 일시 정지 상태로 만듬
            wait();
        } catch (InterruptedException e) {
        }
    }

    public synchronized void methodB() {
        System.out.println("ThreadB의 methodB() 작업 실행");
        // 일시 정지 상태에 있는 ThreadA 를 실행 대기 상태로 만듬
        notify();
        try {
            // ThreadB를 일시 정지 상태로 만듬
            wait();
        } catch (InterruptedException e) {
        }
    }
}
