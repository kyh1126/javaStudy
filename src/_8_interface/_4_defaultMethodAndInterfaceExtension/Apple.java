package _8_interface._4_defaultMethodAndInterfaceExtension;

public class Apple implements Fruit {
    private String name = Apple.class.getSimpleName();

    @Override
    public void name() {
        System.out.println(name);
    }
}
