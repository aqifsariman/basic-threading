package sdf.ibf;

@FunctionalInterface
public interface MyRunnableInterface<T> {

    T process(T a, T b);
}
