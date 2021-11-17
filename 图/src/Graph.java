public interface Graph<V,E> {
    int vertexSize();
    int edgeSize();

    void addVertex(V v);
    void addEdges(V from,V to);
    void addEdges(V from,V to,E weight);

    void removeVertex(V v);
    void removeEdge(V from,V to);

    void bfs(V begin);
}
