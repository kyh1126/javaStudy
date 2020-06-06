package _12_multiThread._3_threadState;

public class StatePrintThread extends Thread {
    private TargetThread targetThread;

    @Override
    public void run() {
        while (true) {
            Thread.State state = targetThread.getState();
            System.out.println("타겟 스레드 상태: " + state);

            if (state == State.NEW) {
                targetThread.start();
            }

            if (state == State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public StatePrintThread(TargetThread targetThread) {
        this.targetThread = targetThread;
    }
}
