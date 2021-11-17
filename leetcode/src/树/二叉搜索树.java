package 树;


import 树.printer.BinaryTreeInfo;
import 树.printer.Visitor;

import javax.print.attribute.standard.NumberUp;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树<E> implements BinaryTreeInfo {

    protected int N = 0;
    protected Node<E> root;
    protected Comparator<E> comparator;

    public 二叉搜索树(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public 二叉搜索树() {
    }

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
        return ((Node)node).element;
    }
    protected Node<E> createNode(E element, Node<E> parent){
        return new Node(element,parent);
    }
    public static class Node<E>{
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }
    }

    public int size(){
        return N;
    }
    protected void afteradd(Node node){}

    public void add(E element){
        checkElement(element);
        if (isEmpty()){
            root = createNode(element,null);
            N++;
            afteradd(root);
            return;
        }
        Node<E> newroot = root;
        Node<E> parent = root;
        Node<E> add;
        int com = 0;

        while (newroot != null){
            parent = newroot;
            com = compare(element, newroot.element);
            if (com > 0){
                newroot = newroot.right;
            }else {
                if (com < 0){
                    newroot = newroot.left;
                }else {
                    newroot.element = element;
                    return;
                }
            }
        }
        if (com > 0){
            parent.right = createNode(element,parent);
            add = parent.right;
        }else {
            parent.left = createNode(element,parent);
            add = parent.left;
        }
        afteradd(add);
        N++;
    }
    protected void afterRemove(Node<E> node,Node renode) {}
    public void remove(Node node){
        if (node == null) return;

        if (node.left != null&&node.right != null){
            Node houqu = houqu(node);
            node.element = houqu.element;
            node = houqu;
        }

        if (node.left==null&&node.right==null){
            if (node.parent == null){
                root = null;
                afterRemove(node,null);
                N--;
                return;
            }
            if (node.parent.left == node){
                node.parent.left = null;
                afterRemove(node,null);
                N--;
                return;
            }else {
                node.parent.right = null;
                afterRemove(node,null);
                N--;
                return;
            }
        }

        if (node.left!=null&&node.right==null){
            Node renode = node.left;
            if (node.parent == null){
                root = node.left;
                root.parent = null;
                afterRemove(node,root);
                N--;
                return;
            }
            if (node.parent.left == node){
                renode.parent = node.parent;
                node.parent.left = node.left;
                afterRemove(node,renode);
                N--;
            }else {
                renode.parent = node.parent;
                node.parent.right = node.left;
                afterRemove(node,renode);
                N--;
            }
        }
        if (node.left==null&&node.right!=null){
            Node renode = node.right;
                if (node.parent == null){
                    root = node.right;
                    root.parent = null;
                    afterRemove(node,root);
                    N--;
                    return;
                }
                if (node.parent.left == node){
                    renode.parent = node.parent;
                    node.parent.left = node.right;
                    afterRemove(node,renode);
                    N--;
                }else {
                    renode.parent = node.parent;
                    node.parent.right = node.right;
                    afterRemove(node,renode);
                    N--;
                }
        }

    }

    public void clear(){
        root = null;
        N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public boolean contains(E element){
        return false;
    }

    public void checkElement(E element){
        if (element == null)
            throw new RuntimeException("不允许为空");

    }
    public int compare(E a, E b){
        if (comparator != null){
            return comparator.compare(a,b);
        }else {
            return ((Comparable<E>)a).compareTo(b);
        }
    }

    public Node node(E element){
        Node node = root;
        while (node != null){
            int com = compare((E) node.element, element);
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

    public E getElement(E element){
        return (E) node(element).element;
    }

    /**
     * 遍历
     */
    public void Traverse(Visitor visitor){
        afterTraverse(root,visitor);
    }

    /**
     * 前序遍历
     */
    private void beforeTraverse(Node<E> node,Visitor visitor){
        if (node == null)
            return;
        visitor.visit(node.element);
        beforeTraverse(node.left,visitor);
        beforeTraverse(node.right,visitor);
    }

    /**
     * 中序遍历
     */
    private void midTraverse(Node<E> node,Visitor visitor){
        if (node == null)
            return;
        midTraverse(node.left,visitor);
        visitor.visit(node.element);
        midTraverse(node.right,visitor);
    }

    /**
     * 后序遍历
     */
    private void afterTraverse(Node<E> node,Visitor visitor){
        if (node == null)
            return;
        afterTraverse(node.right,visitor);
        afterTraverse(node.left,visitor);
        visitor.visit(node.element);
    }

    /**
     * 层序遍历
     */
    private void cengTraverse(Visitor visitor){
        Queue queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node poll = (Node)queue.poll();
            if (visitor.visit(poll.element))return;
            if (poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }
    }

    public int hight(){
        int hight = 0;
        Queue queue = new LinkedList<Node>();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()){
            Node poll = (Node)queue.poll();
            size--;
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            if (size == 0){
                size = queue.size();
                hight++;
            }
        }
        return hight;
    }

    public int hight1(){
        return hight1(root);
    }
    public int hight1(Node node){
        if (node == null) return 0;
        return 1+Math.max(hight1(node.left),hight1(node.right));
    }

    /**
     * 翻转二叉树
     */
    private Node node1;
    public void fanzhuan(Node<E> node){
        if (node == null)
            return;
        fanzhuan(node.right);
        fanzhuan(node.left);
        node1 = node.left;
        node.left = node.right;
        node.right = node1;
    }

    /**
     * 前驱节点
     */
    public Node qianqu(Node<E> node){
        if (node == null) return null;
        Node p = node;
        if (node.left!=null){
            p = p.left;
            while (p.right!=null){
                p = p.right;
            }
            return p;
        }

        while (p.parent!=null && p.parent.left == p){
            p = p.parent;
        }
        if (p.parent == null) return null;
        return p.parent;
    }

    /**
     * 后驱节点
     */
    public Node houqu(Node<E> node){
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

    public Node commonGrand(E p1,E q1){
        Node p = node(p1);
        Node q = node(q1);
        return commonGrand(root,p,q);
    }

    private Node commonGrand(Node root,Node p,Node q){
        if (root == null || root == p || root == q) return root;

        Node left = commonGrand(root.left, p, q);
        Node right = commonGrand(root.right, p, q);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }

    public void right(){
        right(root);
        E tmp =(E) first.element;
        first.element = second.element;
        second.element = tmp;
    }
    private Node first;
    private Node second;
    private Node lastNode;
    private void right(Node root){
        if (root == null) return;

        right(root.left);

        if (lastNode != null && compare((E)lastNode.element,(E)root.element) > 0){
            if (first == null){
                first = lastNode;
            }
            second = root;
        }

        lastNode = root;

        right(root.right);
    }

    public void inorder(Visitor visitor){
        Node node = root;
        while (node != null){
            if (node.left != null){
                Node qianqu = node.left;
                while (qianqu.right != null && qianqu.right != node){
                    qianqu = qianqu.right;
                }
                if (qianqu.right == null){
                    qianqu.right = node;
                    node = node.left;
                }else {
                    qianqu.right = null;
                    visitor.visit(node.element);
                    node = node.right;
                }
            }else {
                visitor.visit(node.element);
                node = node.right;
            }
        }
    }

}
