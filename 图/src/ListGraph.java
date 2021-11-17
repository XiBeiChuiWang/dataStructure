import java.util.*;

public class ListGraph<V,E> implements Graph {
    Map<V, Vertex> vertexMap = new HashMap<V,Vertex>();
    public Set<Edge> edgeSet = new HashSet<Edge>();

    public void print(){
        Iterator<Map.Entry<V, Vertex>> iterator = vertexMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<V, Vertex> next = iterator.next();
            System.out.println(next.getKey());
        }
        Iterator<Edge> iterator1 = edgeSet.iterator();
        while (iterator1.hasNext()){
            Edge next = iterator1.next();
            System.out.println(next);
        }
    }

    private void checkVertex(Vertex vertex){
        if (vertex == null)
            throw new RuntimeException("输入有误");
    }

    @Override
    public int vertexSize() {
        return vertexMap.size();
    }

    @Override
    public int edgeSize() {
        return edgeSet.size();
    }

    @Override
    public void addVertex(Object o) {
        vertexMap.put((V) o,new Vertex(o));
    }

    @Override
    public void addEdges(Object from, Object to) {
        addEdges(from,to,null);
    }

    @Override
    public void addEdges(Object from, Object to, Object weight) {
        Vertex vertexFrom = vertexMap.get(from);
        Vertex vertexTo = vertexMap.get(to);

        if (vertexFrom == null){
            vertexFrom = new Vertex(from);
            vertexMap.put((V) from,vertexFrom);
        }
        if (vertexTo == null){
            vertexTo = new Vertex(to);
            vertexMap.put((V) to,vertexTo);
        }
        //判断是否已存在边
        Edge<V,E> edge = new Edge<V,E>(new Vertex<V,E>((V) from),new Vertex<V,E>((V) to));
        if (vertexFrom.outEdges.remove(edge)){
            vertexTo.inEdges.remove(edge);
            edgeSet.remove(edge);
        }

        edge.weight = (E) weight;
        vertexFrom.outEdges.add(edge);
        vertexTo.inEdges.add(edge);
        edgeSet.add(edge);
    }

    @Override
    public void removeVertex(Object o) {
        Vertex vertex = vertexMap.get(o);
        checkVertex(vertex);
        Iterator iterator = vertex.inEdges.iterator();
        while (iterator.hasNext()){
            Edge next = (Edge)iterator.next();
            iterator.remove();
            Vertex from = next.from;
            from.outEdges.remove(next);
            edgeSet.remove(next);
        }
        iterator = vertex.outEdges.iterator();
        while (iterator.hasNext()){
            Edge next = (Edge)iterator.next();
            iterator.remove();
            Vertex to = next.to;
            to.inEdges.remove(next);
            edgeSet.remove(next);
        }
        vertexMap.remove(o);
    }

    @Override
    public void removeEdge(Object from, Object to) {
        Vertex vertexFrom = vertexMap.get(from);
        checkVertex(vertexFrom);
        Vertex vertexTo = vertexMap.get(to);
        checkVertex(vertexTo);
        Edge<V,E> edge = new Edge<V,E>(new Vertex<V,E>((V) from),new Vertex<V,E>((V) to));
        if (vertexFrom.outEdges.remove(edge)){
            vertexTo.inEdges.remove(edge);
            edgeSet.remove(edge);
        }
    }

    @Override
    public void bfs(Object begin) {
        Vertex vertex = vertexMap.get(begin);
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> set = new HashSet<Vertex>();
        queue.offer(vertex);
        set.add(vertex);
        while (!queue.isEmpty()){
            Vertex poll = queue.poll();
            System.out.println(poll.value);
            Set<Edge<V,E>> outEdges = poll.outEdges;
            for (Edge edge : outEdges){
                Vertex to = edge.to;
                if (set.contains(to)){
                    continue;
                }else {
                    queue.offer(to);
                    set.add(to);
                }
            }
        }
    }

    public static class Vertex<V,E>{//节点
        V value;
        Set<Edge<V,E>> inEdges = new HashSet<>();
        Set<Edge<V,E>> outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        public void setInEdges(Set<Edge<V, E>> inEdges) {
            this.inEdges = inEdges;
        }

        public void setOutEdges(Set<Edge<V, E>> outEdges) {
            this.outEdges = outEdges;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(value,((Vertex)o).value);
        }

        @Override
        public int hashCode() {
            return value == null?0:value.hashCode();
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "value=" + value +
                    '}';
        }
    }

    private static class Edge<V,E>{//边
        Vertex<V,E> from;
        Vertex<V,E> to;
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            Edge<V,E> edge = (Edge<V,E>)o;
            return Objects.equals(from,edge.from) && Objects.equals(to,edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }


}
