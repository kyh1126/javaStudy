package _12_multiThread._5_daemonThread;

// 데몬 스레드: 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다. 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료되는데, 그 이유는
//           주 스레드의 보조 역할을 수행하므로 주 스레드가 종료되면 데몬 스레드의 존재 의미가 없어지기 때문이다.
//           ex> 워드의 자동 저장, 미디어 플레이어의 동영상 및 음악 재생, 가비지 컬렉터 등

public class DaemonThreadEx1 {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        // 데몬 스레드로 만듬.
        autoSaveThread.setDaemon(true);
        // start 메소드 호출된 후 setDaemon 호출하면 IllegalThreadStateException 터진다.
        autoSaveThread.start();

        System.out.println(autoSaveThread.isDaemon() ? "daemon!" : "not daemon!");
        try {
            // 메인 스레드 3초 후 종료되면 데몬 스레드도 같이 종료된다.
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("메인 스레드 종료");
    }
}
