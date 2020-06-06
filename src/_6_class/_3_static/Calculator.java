package _6_class._3_static;

public class Calculator {
    static double pi = 3.14159;
    static String res;

    static int plus(int x, int y) {
        return x + y;
    }

    static {
        res = Double.toString(pi + 3);
    }
}
