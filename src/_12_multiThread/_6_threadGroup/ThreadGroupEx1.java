package _12_multiThread._6_threadGroup;

import _12_multiThread._5_daemonThread.AutoSaveThread;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

// 스레드 그룹: 관련된 스레드를 묶어서 관리할 목적으로 이용된다. JVM 이 실행되면 system 스레드 그룹을 만들고, JVM 운영에 필요한 스레드들을 생성해서
//           system 스레드 그룹에 포함시킨다. 그리고 system 의 하위 스레드 그룹으로 main 을 만들고 메인 스레드를 main 스레드 그룹에 포함시킨다.
//           스레드는 반드시 하나의 스레드 그룹에 포함되는데, 명시적으로 스레드 그룹에 포함시키지 않으면 기본적으로 자신을 생성한 스레드와 같은 스레드 그룹에
//           속하게 된다. 우리가 생성하는 작업 스레드는 대부분 main 스레드가 생성하므로 기본적으로 main 스레드 그룹에 속하게 된다.

// Finalizer 스레드: 가비지 컬렉션을 담당. system 스레드 그룹에 속한다.
// main 스레드: main() 메소드를 실행. system 그룹의 하위 그룹인 main 스레드 그룹에 속한다.
public class ThreadGroupEx1 {
    public static void main(String[] args) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        // 현재 스레드가 속한 스레드 그룹의 이름 얻기
        String groupName = group.getName();
        System.out.println("groupName: " + groupName);

        // 프로세스 내에서 실행하는 모든 스레드에 대한 정보를 얻을 수 있다.
        // 스레드 객체, 스레드의 상태 기록들
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        allStackTraces.forEach((thread, stackTraceElements) -> {
            System.out.println("thread: " + thread.getName() + ", stackTraceElements: " + Arrays.stream(stackTraceElements).collect(Collectors.toList()));
        });

        // ----------

        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        map.keySet().forEach(thread -> {
            System.out.println("Name: " + thread.getName() + (thread.isDaemon() ? "(데몬)" : "(주)"));
            System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
            System.out.println();
        });

    }
}
