package _13_generic._1_whyGeneric;

public class Util {
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<T>();
        box.setT(t);
        return box;
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valCompare = p1.getValue().equals(p2.getValue());
        return keyCompare && valCompare;
    }

    // Number 하위타입: Byte, Short, Integer, Long, Double
    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        // 첫 번째 매개값이 작으면 -1, 같으면 0, 크면 1을 리턴.
        return Double.compare(v1, v2);
    }
}
