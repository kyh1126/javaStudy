package _12_multiThread._1_multiThread;

// OS 에서는 실행중인 하나의 애플리케이션을 프로세스(process) 라고 부른다.
// 사용자가 애플리케이션을 실행하면 OS 로부터 실행에 필요한 메모리를 할당받아 애플리케이션의 코드를 실행하는데, 이것이 프로세스이다.
// 하나의 애플리케이션은 다중 프로세스를 만들기도 하는데, 예를 들어 크롬 브라우저를 2개 실행했다면 2개의 크롬 프로세스가 생성된 것이다.

// 멀티 태스킹(multi tasking): 2가지 이상의 작업을 동시에 처리하는 것.
// OS는 멀티 태스킹을 할 수 있도록 CPU 및 메모리 자원을 프로세스마다 적절히 할당해주고 병렬로 실행시킨다.
// 멀티 태스킹이 멀티 프로세스를 뜻하지는 않는다. 한 프로세스 내에서 멀티 태스킹 할 수 있도록 만들어진 애플리케이션도 있다. ex> 메신저(채팅 with 파일 전송)

// 멀티 스레드(multi thread): 하나의 프로세스가 2가지 이상의 작업을 처리 가능하게 한다. 애플리케이션 내부에서의 멀티 태스킹.
// 멀티 프로세스: 애플리케이션 단위의 멀티 태스킹.

// 멀티 프로세스 - 프로세스 1 - 멀티 스레드 1
//                         멀티 스레드 2
//            - 프로세스 2 - 싱글 스레드
//            - 프로세스 3 - 멀티 스레드 1
//                         멀티 스레드 2
//                         멀티 스레드 3
// 멀티 프로세스들은 OS 에서 할당받은 자신의 메모리를 가지고 실행하기 때문에 서로 독립적이라 한 프로세스에서 오류가 발생해도 다른 프로세스에 영향을 미치지 않는다.
// 하지만 멀티 스레드는 하나의 프로세스 내부에 생성되기 때문에 한 스레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있어 다른 스레드에 영향을 미치기 된다.
public class MultiThreadEx1 {
}
