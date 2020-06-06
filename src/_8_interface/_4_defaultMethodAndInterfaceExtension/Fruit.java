package _8_interface._4_defaultMethodAndInterfaceExtension;

public interface Fruit {
    void name();

    default void run() {
        System.out.println("Fruit run!");
    }
}
