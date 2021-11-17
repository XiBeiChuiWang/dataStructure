package printer;

public interface Visitor<E> {
    boolean visit(E element);
}
