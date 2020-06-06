package _8_interface._4_defaultMethodAndInterfaceExtension;

public interface ChildOverrideFruit extends Fruit {
    @Override
    default void run() {
        System.out.println("fruit run 재정의");
    }
}
