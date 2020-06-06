package _13_generic._1_whyGeneric;

public interface Storage<T> {
    void add(T item, int index);

    T get(int index);
}
