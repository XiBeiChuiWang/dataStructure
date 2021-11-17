package 我以为很简单但是这些题却一直在打我的脸_高频题;

import java.util.HashMap;
import java.util.Map;

public class LRUcache<K,V> {
    private Map<K,Node> map;
    private Node first;
    private Node last;
    private int maxcount;

    public LRUcache(int maxcount) {
        map = new HashMap();
        first = new Node(null,null);
        last = new Node(null,null);
        first.next = last;
        last.prev = first;
        this.maxcount = maxcount;
    }

    public Map<K, Node> getMap() {
        return map;
    }

    public int get(K key){
        Node node = map.get(key);
        if (node == null)
            return -1;

        if (node.prev != first){
            removeNode(node);
            addAfterFirst(node);
        }
        return 1;
    }

    public void put(K key,V value){
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = node.value;
            if (node.prev != first){
                removeNode(node);
                addAfterFirst(node);
            }
        }else {
            if (map.size() >= maxcount){
                Node prev = last.prev;
                removeNode(prev);
                map.remove(prev.key);
            }

            Node<K, V> kvNode = new Node<>(key, value);
            map.put(key,kvNode);
            addAfterFirst(kvNode);
        }
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAfterFirst(Node node){
        node.next = first.next;
        node.next.prev = node;

        node.prev = first;
        first.next = node;
    }
    private static class Node<K,V> {
        private K key;
        private V value;
        private Node prev;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
