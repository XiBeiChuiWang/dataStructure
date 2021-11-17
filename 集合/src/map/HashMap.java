package map;

import map.printer.BinaryTreeInfo;
import map.printer.BinaryTrees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class HashMap<K,V> implements Map<K,V> {
    private Node[] table;
    int size;

    public HashMap(int length) {
        table = new Node[length];
    }

    public HashMap() {
        table = new Node[16];
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
        if (size == 0) return;
        size = 0;
        for (int i = 0;i < table.length;i++){
            table[i] = null;
        }
    }

    @Override
    public V put(K key, V value) {
        int index = index(key);
        Node root = table[index];
        if (root == null){
            root = new Node<K,V>(key,value,null);
            table[index] = root;
            afterPut(root);
            size++;
            return null;
        }

        Node<K,V> newroot = root;
        Node<K,V> parent = root;
        Node<K,V> add;
        int com = 0;
        int h1 = key == null ? 0 :key.hashCode();
        K k1 = key;
        Node resulet;
        do {
            parent = newroot;
            K k2 = newroot.key;
            int h2 = newroot.hash;
            if (h1 > h2) {
                com = 1;
            }else if (h1 <h2){
                com = -1;
            }else if (Objects.equals(k1,k2)){
                com = 0;
            }else if (k1 != null&&k2 != null
                    &&k1.getClass() == k2.getClass()
                    &&k1 instanceof Comparable){
                com = ((Comparable) k1).compareTo(k2);
            }else {
                if (newroot.left != null && (resulet = node(newroot.left,key)) != null
                        || newroot.right != null && (resulet = node(newroot.right,key)) != null){
                    newroot = resulet;
                    com = 0;
                }else {
                    com = System.identityHashCode(k1) - System.identityHashCode(k2);
                }
            }

            if (com > 0){
                newroot = newroot.right;
            }else if (com < 0){
                newroot = newroot.left;
            }else {
                V vold = newroot.value;
                newroot.value = value;
                return vold;
            }

        }while (newroot != null);
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
                table[index(node)] = null;
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
                table[index(node)] = node.left;
                table[index(node)].parent = null;
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
                table[index(node)] = node.right;
                table[index(node)].parent = null;
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

    private boolean colorOf(Node node) {
        return node == null ? BLACK : node.color;
    }

    @Override
    public V get(K key) {
        Node node = node(key);
        if (node != null){
            return (V) node.value;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return node(key) == null;
    }

    @Override
    public boolean containsValue(V value) {
        if (size == 0) return false;
        for (int i = 0;i < table.length;i++){
            if (table[i] == null) continue;
            Queue queue = new LinkedList<Node>();
            queue.offer(table[i]);
            while (!queue.isEmpty()){
                Node poll = (Node) queue.poll();
                if (poll.value.equals(value)) return true;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (size == 0||visitor==null) return;
        for (int i = 0;i < table.length;i++){
            if (table[i] == null) continue;
            Queue queue = new LinkedList<Node>();
            queue.offer(table[i]);
            while (!queue.isEmpty()){
                Node poll = (Node) queue.poll();
                visitor.visit((K) poll.key,(V) poll.value);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
    }

    private void zhongxu(Node node, Visitor visitor){
        if (node == null) return;
        zhongxu(node.left,visitor);
        if (visitor.visit(node.key,node.value)) return;
        zhongxu(node.right,visitor);
    }

    private int index(K key){
        if (key == null) return 0;
        int hash = key.hashCode();
        hash = hash ^ (hash >>> 16);
        int index = hash & (table.length - 1);
        return index;
    }

    private int index(Node node){
        return (node.hash ^ (node.hash >>> 16)) & (table.length - 1);
    }

    private int compare(K a,K b,int a1,int b1) {
        int result = a1 - b1;
        if (result != 0) return result;
        boolean equals = a.equals(b);
        if (equals) {
            return result;
        } else {
            return System.identityHashCode(a) - System.identityHashCode(b);
        }
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

    private void afterRotate(Node grand, Node parent, Node child){
        parent.parent = grand.parent;
        if (grand.isLeftChild()){
            grand.parent.left = parent;
        }else {
            if (grand.isRightChild()){
                grand.parent.right = parent;
            }else {
                table[index(grand)] = parent;
            }
        }
        if (child != null) {
            child.parent = grand;
        }
        grand.parent = parent;
    }

    private Node node(K key){
        Node root = table[index(key)];
        return root == null ? null :node(root,key);
    }

    private Node node(Node node ,K k1){
        int h1 = k1 == null ? 0 :k1.hashCode();
        Node resulet;
        while (node != null) {
            int h2 = node.hash;
            K k2 = (K) node.key;
            if (h1 > h2) {
                node = node.right;
            } else if (h1 < h2) {
                node = node.left;
            } else if (Objects.equals(k1, k2)) {
                return node;
            } else if (k1 != null&&k2 != null
            &&k1.getClass() == k2.getClass()
            &&k1 instanceof Comparable){
                int cmp = ((Comparable) k1).compareTo(k2);
                if (cmp > 0){
                    node = node.right;
                }else if (cmp < 0){
                    node = node.left;
                }else {
                    return node;
                }
            }else if (node.right != null&&(resulet = node(node.right,k1)) != null){
                return resulet;
            }else if (node.left != null&&(resulet = node(node.left,k1)) != null){
                return resulet;
            }else {
                return null;
            }

        }
            return null;
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

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    static class Node<K,V>{
        K key;
        V value;
        int hash;
        boolean color = RED;
        Node<K,V> left;
        Node<K,V> right;
        Node<K,V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.hash = key == null ? 0 : key.hashCode();
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

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    public void print(){
        for (int i = 0;i < table.length;i++){
            Node root = table[i];
            System.out.println("------------------------------------------"+i);
                BinaryTrees.println(new BinaryTreeInfo() {
                    @Override
                    public Object root() {
                        return root;
                    }

                    @Override
                    public Object left(Object node) {
                        return ((Node)node).left;
                    }

                    @Override
                    public Object right(Object node) {
                        return ((Node)node).right;
                    }

                    @Override
                    public Object string(Object node) {
                        return node;
                    }
                });

        }
    }

}
