package _12_multiThread._4_controlThreadState;

public class ProduceConsumeEx6 {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();

        ProducerThread producer = new ProducerThread(dataBox);
        ConsumerThread consumer = new ConsumerThread(dataBox);

        producer.start();
        consumer.start();
    }
}
