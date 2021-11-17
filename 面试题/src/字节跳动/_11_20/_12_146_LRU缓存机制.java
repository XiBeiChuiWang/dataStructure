package 字节跳动._11_20;

import java.util.HashMap;

public class _12_146_LRU缓存机制 {
    private int maxLength;
    private Node first;
    private Node last;
    private HashMap<Integer,Node> hashMap;

    public _12_146_LRU缓存机制(int capacity) {
        if (capacity < 1)
            throw new RuntimeException("容量最小为1");
        maxLength = capacity;
        first = new Node(null,null);
        last = new Node(null,null);
        first.next = last;
        last.prev = first;
        hashMap = new HashMap();
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) return -1;
        removeNode(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node == null){
            if (hashMap.size() == maxLength){
                Node prev = last.prev;
                hashMap.remove(prev);
                removeNode(last.prev);
            }
            Node node1 = new Node(key, value, null, null);
            addFirst(node1);
            hashMap.put(key,node1);
        }else {
            node.value = value;
            removeNode(node);
            addFirst(node);
            hashMap.put(key,node);
        }
    }

    private void addFirst(Node node){
        Node ne = first.next;
        node.prev = first;
        first.next = node;
        node.next = ne;
        ne.prev = node;
    }

    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private static class Node{
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
    }
}
