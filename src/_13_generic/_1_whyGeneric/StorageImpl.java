package _13_generic._1_whyGeneric;


public class StorageImpl<T> implements Storage<T> {
    private T[] arr;

    public StorageImpl(int capacity) {
        arr = (T[]) new Object[capacity];
    }

    @Override
    public void add(T item, int index) {
        arr[index] = item;
    }

    @Override
    public T get(int index) {
        return arr[index];
    }
}
