package _12_multiThread._4_controlThreadState;

public class ThreadB2 extends Thread {
    private WorkObject workObject;

    public ThreadB2(WorkObject workObject) {
        // 공유 객체를 매개값으로 받아 필드에 저장
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodB();
        }
    }
}
