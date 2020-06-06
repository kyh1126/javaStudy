package _12_multiThread._2_synchronized;

// 멀티 스레드 프로그램에서는 스레드들이 객체를 공유해서 작업해야 하는 경우가 잇다.
// 스레드 A를 사용하던 객체가 스레드 B에 의해 상태가 변경될 수 있기 때문에 스레드 A가 의도했던 것과는 다른 결과를 산출할 수도 있다.
public class ShareObjectEx1 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(cal);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(cal);
        user2.start();
    }
}
