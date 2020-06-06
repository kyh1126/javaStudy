package _8_interface._4_defaultMethodAndInterfaceExtension;

// 디폴트 메소드가 있는 인터페이스 상속 활용
// 1. 디폴트 메소드를 단순히 상속만 받는다.
// 2. 디폴트 메소드를 재정의(Override)해서 실행 내용을 변경한다.
// 3. 디폴트 메소드를 추상 메소드로 재선언한다.
public class InterfaceExtensionEx2 {
    public static void main(String[] args) {
        Fruit f1 = new Kiwi();
        f1.run();
        System.out.println();

        ChildOverrideFruit f2 = new ChildOverrideFruit() {
            @Override
            public void name() {
                System.out.println("ChildOverrideFruit");
            }
        };
        f2.run();
        System.out.println();

        ChildAbstractFruit f3 = new ChildAbstractFruit() {
            @Override
            public void run() {
                System.out.println("ChildAbstractFruit run!");
            }

            @Override
            public void name() {
                System.out.println("ChildAbstractFruit");
            }
        };
        f3.run();
    }
}
