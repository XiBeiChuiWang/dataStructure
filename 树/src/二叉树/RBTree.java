package 二叉树;

import java.util.Comparator;

public class RBTree<E> extends 二叉搜索树 {
    private static final boolean RED = false;
    private static final boolean Black = true;

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }


    @Override
    protected Node<E> createNode(Object element, Node parent) {
        return new RBNode<E>((E) element,parent);
    }

    public static class RBNode<E> extends Node<E>{
        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public boolean isLeftChild(){
            if (this.parent != null && this.parent.left == this){
                return true;
            }
            return false;
        }

        public boolean isRightChild(){
            if (this.parent != null && this.parent.right == this){
                return true;
            }
            return false;
        }

        public Node sibling(){
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
            String str = "";
            if (color == RED){
                str = "R_";
            }else {
                str = "B_";
            }
            return str + element.toString();
        }
    }

    @Override
    protected void afteradd(Node node) {
        RBNode parent = (RBNode)node.parent;
        if (parent == null)
            black(node);
        //直接添加
        if (isBlack(parent)) return;
        //上溢 叔父节点红色
        RBNode grand = (RBNode)parent.parent;
        if (isRed(parent.sibling())){
            black(parent);
            black(parent.sibling());
            red(grand);
            afteradd(grand);
            return;
        }
        //叔父节点不为红色
        if (parent.isLeftChild()){//L
            if (((RBNode)node).isLeftChild()){//LL
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
            if (((RBNode)node).isLeftChild()){//RL
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
    protected void afterRemove(Node node,Node renode) {
        if (isRed(node)) return;
        if (isRed(renode)){
            black(renode);
            return;
        }

        if(node.parent == null) return;

//        if (isBlack(node)){
//            Node grand = node.parent;
//            Node parent = ((RBNode)node).sibling();
//            if (parent.left==null&&parent.right==null) return;
//            if (parent.left==null){
//                red(parent);
//                black(grand);
//                black(parent.right);
//                rotateLeft(grand);
//                return;
//            }
//
//            black(grand);
//            rotateRight(parent);
//            rotateLeft(grand);
//            return;
//        }
    }

    private Node color(Node node, boolean color){
        if (node == null) return node;
        ((RBNode)node).color = color;
        return node;
    }

    private Node red(Node node){
        return color(node,RED);
    }

    private Node black(Node node){
        return color(node,Black);
    }

    private boolean colorof(Node node){
        return node ==null?Black:((RBNode)node).color;
    }

    private boolean isBlack(Node node){
        return colorof(node) == Black;
    }

    private boolean isRed(Node node){
        return colorof(node) == RED;
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
        if (((RBNode)grand).isLeftChild()){
            grand.parent.left = parent;
        }else {
            if (((RBNode)grand).isRightChild()){
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


}
