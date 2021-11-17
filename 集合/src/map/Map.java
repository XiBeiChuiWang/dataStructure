package map;

import sun.reflect.generics.visitor.Visitor;

public interface Map<K,V>{
    int size();
    boolean isEmpty();
    void clear();
    V put(K key,V value);
    V remove(K key);
    V get(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void traversal(Visitor<K,V> visitor);

    public static abstract class Visitor<K,V>{
        abstract boolean visit(K key,V value);
    }
}
