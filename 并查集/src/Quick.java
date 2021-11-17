import java.util.HashMap;
import java.util.HashSet;

public class Quick<V> implements 并查集 {
    private HashMap<V,Node> hashMap;

    public Quick(V[] v) {
        hashMap = new HashMap<V,Node>();
        for (V v1:v
             ) {
            hashMap.put(v1,new Node(v1,null));
        }
    }


    @Override
    public boolean isConnected(Object p, Object q) {
        return find((V)p) == find((V)q);
    }

    @Override
    public void union(Object p, Object q) {
        Node pnode = find((V) p);
        Node qnode = find((V) q);
        if (pnode.high < qnode.high){
            pnode.parent = qnode;
        }else if (pnode.high > qnode.high){
            qnode.parent = pnode;
        }else {
            pnode.parent = qnode;
            qnode.high++;
        }
    }

    private Node find(V v){
        Node node = hashMap.get(v);
        if (node == null)
            throw new RuntimeException("输入有误");
        while (node.parent != null){
            node = node.parent;
        }
        return node;

    }

    private class Node<V>{
        V v;
        int high = 1;
        Node parent;

        public Node(V v, Node parent) {
            this.v = v;
            this.parent = parent;
        }
    }
}
