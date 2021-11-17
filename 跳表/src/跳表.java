import java.util.Comparator;

public class 跳表 <K,V>{

    private static final int MAX_LEVEL = 32;
    private static final double P = 0.25;

    private int size;
    private Comparator comparator;
    private Node first;
    private int level;

    public 跳表(Comparator comparator) {
        this.comparator = comparator;
        first = new Node(null,null,MAX_LEVEL);
    }

    public 跳表() {
        this(null);
    }

    public boolean isempty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public V put(K key,V value){
        Node node = this.first;
        Node[] nodes = new Node[level];
        //将Node存入数组
        for (int i = level - 1;i >= 0;i--){
            int com = -1;
            while ((node.next[i]) != null && (com = compare(key, (K) node.next[i].key)) > 0){
                node = node.next[i];
            }
            if (com == 0){
                V oldValue = (V) node.next[i].value;
                node.next[i].value = value;
                return oldValue;
            }
            nodes[i] = node;
        }

        int newlevel = randomLevel();
        Node<K, V> newNode = new Node<>(key, value, newlevel);

        for (int i = 0;i < newlevel;i++){
            if (i >= level){
                first.next[i] = newNode;
            }else {
                newNode.next[i] = nodes[i].next[i];
                nodes[i].next[i] = newNode;
            }
        }

        size++;

        level = Math.max(level,newlevel);
        return null;
    }

    public V get(K key){
        Node node = this.first;
        for (int i = level - 1;i >= 0;i--){
            int com = -1;
            while ((node.next[i]) != null && (com = compare(key, (K) node.next[i].key)) > 0){
                node = node.next[i];
            }
            if (com == 0) return (V) node.next[i].value;
        }
        return null;
    }

    public V remove(K key){
        Node node = this.first;
        Node[] nodes = new Node[level];
        boolean exist = false;
        //将Node存入数组
        for (int i = level - 1;i >= 0;i--){
            int com = -1;
            while ((node.next[i]) != null && (com = compare(key, (K) node.next[i].key)) > 0){
                node = node.next[i];
            }
            if (com == 0) exist = true;
            nodes[i] = node;
        }
        //无此元素
        if (!exist) return null;

        Node removeNode = node.next[0];
        //设置后继节点
        for (int i = 0;i < removeNode.next.length;i++){
            nodes[i].next[i] = removeNode.next[i];
        }

        size--;

        // 更新跳表的层数
        int newLevel = level;
        while (--newLevel >= 0 && first.next[newLevel] == null) {
            level = newLevel;
        }

        return (V) removeNode.value;
    }

    private int compare(K k1, K k2){
        return comparator != null ? comparator.compare(k1,k2) : ((Comparable<K>)k1).compareTo(k2);
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
    private static class Node <K,V>{
        private K key;
        private V value;
        private Node[] next;

        public Node(K key, V value ,int newlevel) {
            this.key = key;
            this.value = value;
            next = new Node[newlevel];
        }

    }
}
