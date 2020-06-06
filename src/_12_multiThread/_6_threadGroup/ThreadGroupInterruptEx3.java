package _12_multiThread._6_threadGroup;

// 스레드 그룹의 일괄 interrupt(): 스레드 그룹 내에 포함된 모든 스레드들을 일괄 interrupt 할 수 있다.(스레드들을 모두 종료시키기)
// 스레드 그룹에는 interrupt 메소드 외에도 suspend, resume, stop 메소드들이 있는데 모두 deprecated 되었다.

// ThreadGroup 이 갖고 있는 주요 메소드들
// -------------------------------------------------------------------------------
// 메소드                      설명
// -------------------------------------------------------------------------------
// activeCount()            현재 그룹 및 하위 그룹에서 활동 중인 모든 스레드의 수를 리턴.
// activeGroupCount()       현재 그룹에서 활동 중인 모든 하위 그룹의 수를 리턴.
// checkAccess()            현재 스레드가 스레드 그룹을 변경할 권한이 있는지 체크. 만약 권한이 없으면 SecurityException 을 발생시킨다.
// destroy()                현재 그룹 및 하위 그룹을 모두 삭제. 단, 그룹 내에 포함된 모든 스레드들이 종료 상태가 되어야 한다.
// isDestroyed()            현재 그룹이 삭제되었는지 여부를 리턴.
// getMaxPriority()         현재 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위를 리턴.
// setMaxPriority(int pri)  현재 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위를 설정.
// getName()                현재 그룹의 이름을 리턴.
// getParent()              현재 그룹의 부모 그룹을 리턴.
// parentOf(ThreadGroup g)  현재 그룹이 매개값으로 지정한 스레드 그룹의 부모인지 여부를 리턴.
// isDaemon()               현재 그룹이 데몬 그룹인지 여부를 리턴.
// setDaemon(boolean b)     현재 그룹을 데몬 그룹으로 설정.
// list()                   현재 그룹에 포함된 스레드와 하위 그룹에 대한 정보를 출력.
// interrupt()              현재 그룹에 포함된 모든 스레드들을 interrupt.
// -------------------------------------------------------------------------------
public class ThreadGroupInterruptEx3 {
    public static void main(String[] args) {
        // 스레드 그룹을 생성하고 정보를 출력해본다.
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");

        workThreadA.start();
        workThreadB.start();

        System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용 ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        // [스레드이름, 우선순위, 소속 그룹명]
        mainGroup.list();
        System.out.println();

        // 3초 후 스레드 그룹의 interrupt() 메소드를 호출해서 스레드 그룹에 포함된 모든 스레드들을 종료시킨다.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]");
        myGroup.interrupt();
    }
}
