package _12_multiThread._2_synchronized;

public class SynchronizedCalculator extends Calculator {
//    public synchronized void setMemory(int memory) {
//        super.memory = memory;
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//        }
//        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
//    }

    public void setMemory(int memory) {
        synchronized (this) {
            super.memory = memory;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
