package _8_interface._4_defaultMethodAndInterfaceExtension;

public class Kiwi implements Fruit {
    private String name = Kiwi.class.getSimpleName();

    @Override
    public void name() {
        System.out.println(name);
    }

    @Override
    public void run() {
        System.out.println("나는 키위 run!");
    }
}
