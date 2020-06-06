package _6_class._2_objectAndClass;

// 1. 리턴값이 있는 메소드: 메소드 선언에 리턴 타입이 있는 메소드는 반드시 리턴문을 사용해서 리턴값을 지정해야 한다.
// 2. 리턴값이 없는 메소드(void): void 로 선언된 리턴값이 없는 메소드에서도 return 문을 사용할 수 있다. return;
public class ReturnStatementEx4 {
    // return 문의 리턴값은 리턴 타입이거나 리턴 타입으로 변환될 수 있어야 한다.
    static int plus(int x, int y) {
        return (byte) (x + y);
    }

    static void run(int gas) {
        while (true) {
            if (gas > 0) {
                System.out.println("gas gas!");
                gas -= 1;
            } else {
                System.out.println("stop!");
                return;
            }
        }
        // Unreachable
//        System.out.println("끝났소이다...");
    }


    public static void main(String[] args) {
        System.out.println("result::" + plus(3, 4));

        // 만약 while 문 뒤에 실행문이 추가적으로 더 있을 경우, break 문을 반드시 사용해야 한다.
        // return 문은 즉시 run 메소드를 종료시키기 때문이다.
        run(5);
    }
}
