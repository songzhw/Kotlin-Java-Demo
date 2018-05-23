package ca.six.jold.generics;

public class Song<T> {
    private T t;

    public Song(T t) {
        this.t = t;
    }

    public T getHelper() {
        return t;
    }

    // 泛型方法
    public <R> R transform(T t, R r) {
        return r;
    }

}
