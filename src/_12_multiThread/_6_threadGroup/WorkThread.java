package _12_multiThread._6_threadGroup;

public class WorkThread extends Thread {
    // thread 그룹과 thread 이름을 설정
    public WorkThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
                break;
            }
        }
        System.out.println(getName() + " 종료됨");
    }
}
