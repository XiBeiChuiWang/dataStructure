package 我以为很简单但是这些题却一直在打我的脸_高频题.BinaryHeep;

public interface Heap<E>{
    int size();
    boolean isEmpty();
    void clear();
    void add(E element);
    E get();
    E remove();
    E replace(E element);
    E peek();
}
