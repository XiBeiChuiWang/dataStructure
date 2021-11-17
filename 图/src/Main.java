public class Main {
    public static void main(String[] args) {
        ListGraph<Integer, Integer> integerIntegerListGraph = new ListGraph<>();
        integerIntegerListGraph.addVertex(1);
        integerIntegerListGraph.addVertex(2);
        integerIntegerListGraph.addVertex(3);
        integerIntegerListGraph.addEdges(4,1,9);
        integerIntegerListGraph.addEdges(1,2,9);
        integerIntegerListGraph.addEdges(2,3,9);
        integerIntegerListGraph.addEdges(3,4,9);
        System.out.println(integerIntegerListGraph.vertexMap.get(1).outEdges);


        integerIntegerListGraph.bfs(4);

    }
}
