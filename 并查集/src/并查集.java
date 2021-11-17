public interface 并查集<V> {
    boolean isConnected(V p , V q);
    void union(V p , V q);
}
