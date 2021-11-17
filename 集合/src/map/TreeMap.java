package map;

import java.util.*;

public class TreeMap<K,V> implements Map<K,V>{
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private int size = 0;
    private Node<K,V> root;
    private Comparator<K> comparator;

    public TreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public TreeMap() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public V put(K key, V value) {
        checkElement(key);
        if (isEmpty()){
            root = new Node<K,V>(key,value,null);
            size++;
            afterPut(root);
            return null;
        }
        Node<K,V> newroot = root;
        Node<K,V> parent = root;
        Node<K,V> add;
        int com = 0;

        while (newroot != null){
            parent = newroot;
            com = compare(key, newroot.key);
            if (com > 0){
                newroot = newroot.right;
            }else {
                if (com < 0){
                    newroot = newroot.left;
                }else {
                    newroot.value = value;
                    return value;
                }
            }
        }
        if (com > 0){
            parent.right = new Node<K,V>(key,value,parent);
            add = parent.right;
        }else {
            parent.left = new Node<K,V>(key,value,parent);
            add = parent.left;
        }
        afterPut(add);
        size++;
        return null;
    }

    private void afterPut(Node node){
        Node parent = node.parent;
        if (parent == null)
            black(node);
        //直接添加
        if (isBlack(parent)) return;
        //上溢 叔父节点红色
        Node grand = parent.parent;
        if (isRed(parent.sibling())){
            black(parent);
            black(parent.sibling());
            red(grand);
            afterPut(grand);
            return;
        }
        //叔父节点不为红色
        if (parent.isLeftChild()){//L
            if (node.isLeftChild()){//LL
                black(parent);
                red(grand);
                rotateRight(grand);
            }else {//LR
                red(grand);
                black(node);
                rotateLeft(parent);
                rotateRight(grand);
            }
        }else {
            if (node.isLeftChild()){//RL
                red(grand);
                black(node);
                rotateRight(parent);
                rotateLeft(grand);
            }else {//RR
                black(parent);
                red(grand);
                rotateLeft(grand);
            }
        }
    }

    @Override
    public V remove(K key) {
        Node node = node(key);
        if (node == null) return null;

        if (node.left != null&&node.right != null){
            Node houqu = houqu(node);
            node.key = houqu.key;
            node.value = houqu.value;
            node = houqu;
        }

        if (node.left==null&&node.right==null){
            if (node.parent == null){
                root = null;
                afterRemove(node);
                size--;
                return null;
            }
            if (node.parent.left == node){
                node.parent.left = null;
                afterRemove(node);
                size--;
                return (V) node.value;
            }else {
                node.parent.right = null;
                afterRemove(node);
                size--;
                return (V) node.value;
            }
        }

        if (node.left!=null&&node.right==null){
            Node renode = node.left;
            if (node.parent == null){
                root = node.left;
                root.parent = null;
                afterRemove(node);
                size--;
                return (V) node.value;
            }
            if (node.parent.left == node){
                renode.parent = node.parent;
                node.parent.left = node.left;
                afterRemove(node);
                size--;
                return (V) node.value;
            }else {
                renode.parent = node.parent;
                node.parent.right = node.left;
                afterRemove(node);
                size--;
                return (V) node.value;
            }
        }
        if (node.left==null&&node.right!=null){
            Node renode = node.right;
            if (node.parent == null){
                root = node.right;
                root.parent = null;
                afterRemove(node);
                size--;
                return (V) node.value;
            }
            if (node.parent.left == node){
                renode.parent = node.parent;
                node.parent.left = node.right;
                afterRemove(node);
                size--;
                return (V) node.value;
            }else {
                renode.parent = node.parent;
                node.parent.right = node.right;
                afterRemove(node);
                size--;
                return (V) node.value;
            }
        }
        return null;
    }

    protected void afterRemove(Node node) {
        // 如果删除的节点是红色
        // 或者 用以取代删除节点的子节点是红色
        if (isRed(node)) {
            black(node);
            return;
        }

        Node parent = node.parent;
        // 删除的是根节点
        if (parent == null) return;

        // 删除的是黑色叶子节点【下溢】
        // 判断被删除的node是左还是右
        boolean left = parent.left == null || node.isLeftChild();
        Node sibling = left ? parent.right : parent.left;
        if (left) { // 被删除的节点在左边，兄弟节点在右边
            if (isRed(sibling)) { // 兄弟节点是红色
                black(sibling);
                red(parent);
                rotateLeft(parent);
                // 更换兄弟
                sibling = parent.right;
            }

            // 兄弟节点必然是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // 兄弟节点没有1个红色子节点，父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else { // 兄弟节点至少有1个红色子节点，向兄弟节点借元素
                // 兄弟节点的左边是黑色，兄弟要先旋转
                if (isBlack(sibling.right)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }

                color(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        } else { // 被删除的节点在右边，兄弟节点在左边
            if (isRed(sibling)) { // 兄弟节点是红色
                black(sibling);
                red(parent);
                rotateRight(parent);
                // 更换兄弟
                sibling = parent.left;
            }

            // 兄弟节点必然是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // 兄弟节点没有1个红色子节点，父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else { // 兄弟节点至少有1个红色子节点，向兄弟节点借元素
                // 兄弟节点的左边是黑色，兄弟要先旋转
                if (isBlack(sibling.left)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }

                color(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }
        }
    }

    private boolean colorOf(Node node) {
        return node == null ? BLACK : node.color;
    }

    @Override
    public V get(K key) {
        Node node = node(key);
        if(node == null){
            return null;
        }else {
            return (V) node.value;
        }
    }


    @Override
    public boolean containsKey(K key) {
        return node(key)!=null;
    }

    @Override
    public boolean containsValue(V value) {
        Queue queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node poll = (Node)queue.poll();
            if (poll.value.equals(value)) return true;
            if (poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }
        return false;
    }

    @Override
    public void traversal(Visitor visitor) {
        zhongxu(root,visitor);
    }

    private void zhongxu(Node node,Visitor visitor){
        if (node == null) return;
        zhongxu(node.left,visitor);
        if (visitor.visit(node.key,node.value)) return;
        zhongxu(node.right,visitor);
    }

    private void checkElement(K key){
        if (key == null)
            throw new RuntimeException("不允许为空");
    }

    private void rotateLeft(Node grand){
        Node parent = grand.right;
        Node child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand,parent,child);
    }

    private void rotateRight(Node grand){
        Node parent = grand.left;
        Node child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand,parent,child);
    }

    private void afterRotate(Node grand,Node parent,Node child){
        parent.parent = grand.parent;
        if (grand.isLeftChild()){
            grand.parent.left = parent;
        }else {
            if (grand.isRightChild()){
                grand.parent.right = parent;
            }else {
                root = parent;
            }
        }
        if (child != null) {
            child.parent = grand;
        }
        grand.parent = parent;
    }

    private Node color(Node node, boolean color){
        if (node == null) return node;
        node.color = color;
        return node;
    }

    private Node red(Node node){
        return color(node,RED);
    }

    private Node black(Node node){
        return color(node,BLACK);
    }

    private boolean colorof(Node node){
        return node ==null?BLACK:node.color;
    }

    private boolean isBlack(Node node){
        return colorof(node) == BLACK;
    }

    private boolean isRed(Node node){
        return colorof(node) == RED;
    }

    private int compare(K a,K b){
        if (comparator != null){
            return comparator.compare(a, b);
        }else {
            return ((Comparable<K>)a).compareTo(b);
        }
    }

    private Node node(K key){
        Node node = root;
        while (node != null){
            int com = compare((K) node.key, key);
            if (com > 0){
                node = node.left;
            }else {
                if (com < 0){
                    node = node.right;
                }else {
                    return node;
                }
            }
        }
        return null;
    }

    private Node houqu(Node node){
        if (node == null) return null;
        Node p = node;
        if (node.right!=null){
            p = p.right;
            while (p.left!=null){
                p = p.left;
            }
            return p;
        }

        while (p.parent!=null && p.parent.right == p){
            p = p.parent;
        }
        if (p.parent == null) return null;
        return p.parent;
    }

    static class Node<K,V>{
        K key;
        V value;
        boolean color = RED;
        Node<K,V> left;
        Node<K,V> right;
        Node<K,V> parent;

        private Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        private boolean isLeftChild(){
            if (this.parent != null && this.parent.left == this){
                return true;
            }
            return false;
        }

        private boolean isRightChild(){
            if (this.parent != null && this.parent.right == this){
                return true;
            }
            return false;
        }

        private Node sibling(){
            if (isLeftChild()){
                return parent.right;
            }
            if (isRightChild()){
                return parent.left;
            }
            return null;
        }

    }

}
