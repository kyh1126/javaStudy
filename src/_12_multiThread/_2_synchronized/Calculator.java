package _12_multiThread._2_synchronized;

public class Calculator {
    protected int memory;

    public void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
}
