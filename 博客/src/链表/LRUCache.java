package 链表;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    int maxCount  = 0;
    int count = 0;
    HashMap<Integer,Node> hashMap = null;
    Node first = new Node(0,0,null,null);
    Node last = new Node(0,0,null,null);

    public LRUCache(int capacity) {
        maxCount = capacity;
        hashMap = new HashMap<Integer, Node>();
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = hashMap.get(key);

        if (node == null){
            return -1;
        }

        removeNode(node);

        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node1 = hashMap.get(key);
        if (node1 != null){
            node1.value = value;
            removeNode(node1);

            addNode(node1);
            return;
        }
        Node node = new Node(key, value, null, null);
        if (count == 0){
            addNode(node);
            count++;
            hashMap.put(key,node);
            return;
        }

        if (count == maxCount){
            Node next = first.next;
            hashMap.remove(next.key);

            removeNode(next);

            addNode(node);
            hashMap.put(key,node);
            return;
        }else {
            addNode(node);
            hashMap.put(key,node);
            count++;
        }

    }

    private void addNode(Node node){
        node.prev = last.prev;
        node.next = last;

        last.prev.next = node;
        last.prev = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
