package _12_multiThread._4_controlThreadState;

public class ThreadB extends Thread {
    public boolean stop;
    public boolean work = true;

    @Override
    public void run() {
        while(!stop){
            if(work){
                System.out.println("ThreadB 작업 내용");
            }else{
                // 다른 스레드에게 실행 양보
                Thread.yield();
            }
        }
        System.out.println("ThreadB 종료");
    }
}
