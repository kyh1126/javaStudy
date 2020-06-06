package _12_multiThread._4_controlThreadState;

public class ProducerThread extends Thread {
    private DataBox dataBox;

    public ProducerThread(DataBox dataBox) {
        // 공유 객체를 필드에 저장
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String data = "Data-" + i;
            dataBox.setData(data);
        }
    }
}
