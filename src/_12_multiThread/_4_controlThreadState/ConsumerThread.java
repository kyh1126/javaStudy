package _12_multiThread._4_controlThreadState;

public class ConsumerThread extends Thread {
    private DataBox dataBox;

    public ConsumerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String data = dataBox.getData();
        }
    }
}
