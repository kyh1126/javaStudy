package _12_multiThread._2_synchronized;

// 스레드가 객체 내부의 동기화 메소드/블록에 들어가면 즉시 객체에 잠금을 걸어 다른 스레드가 임계 영역 코드를 실행하지 못하도록 한다.
// 스레드가 동기화 메소드/블록을 실행 종료하면 잠금이 풀린다.

// 임계 영역(critical section): 단 하나의 스레드만 실행할 수 있는 코드 영역. 자바는 임계 영역 지정을 위해 동기화(synchronized) 메소드/블록 제공.
// synchronized: 인스턴스, 정적 메소드 어디든 붙일 수 있다. 일부 내용만 임계 영역으로 만들고 싶을 때 동기화 블록 만드는 용도로 사용.
//               공유 객체가 객체 자신이면 this 를 넣을 수 있다.
public class SynchronizedEx2 {
    public static void main(String[] args) {
        Calculator cal = new SynchronizedCalculator();

        User1 user1 = new User1();
        user1.setCalculator(cal);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(cal);
        user2.start();
    }
}
