package 链表;

public class 双向链表<E>{
    private int n;
    private Node first = new Node(null,null,null);
    private Node last = new Node(null,null,null);
    private class Node{
        Node next;
        Node prev;
        E element;

        public Node(Node next,Node prev, E element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
    }
    private Node node(int index){
        if (index < size()/2){
            Node node = first;
            for (int i = 1;i<=index;i++){
                node = node.next;
            }
            System.out.println("next");
            return node;
        }else {
            Node node = last;
            for (int i = size();i>=index;i--){
                node = node.prev;
            }
            System.out.println("prev");
            return node;
        }

    }

    public int size(){
        return n;
    }

    public void add(E element){
        if (n == 0){
            first.next = new Node(null,null,element);
            last.prev = first.next;
        }else {
            Node n1 = new Node(null,last.prev,element);
            node(n).next = n1;
            last.prev = n1;
        }
        n++;
    }

    public void add(int index,E element){
        if (index == 1){
            first.next = new Node(first.next,null,element);
            first.next.next.prev = first.next;
        }else {
            Node lnode = node(index - 1);
            lnode.next = new Node(lnode.next,lnode,element);
            lnode.next.next.prev = lnode.next;
        }
        n++;
    }

    public E remove(int index){
        E ele = node(index).element;
        if (index == 1){
            first.next = first.next.next;
            first.next.prev = null;
        }else{
            if (index == n){
                last.prev = last.prev.prev;
                last.prev.next = null;
            }else {
                Node node = node(index - 1);
                node.next = node.next.next;
                node.next.prev = node;
            }

        }
        n--;
        return ele;
    }

    public E get(int index){
        Node node = node(index);
        return node.element;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size = "+size()+"[");
        for (int i = 1;i <= size()-1;i++){
            stringBuilder.append(get(i)+",");
        }
        stringBuilder.append(get(size())+"]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        双向链表<Integer> s = new 双向链表<Integer>();
        for (int i = 1;i<=10;i++){
            s.add(i);
        }
        s.add(2,7);
        s.add(2,7);
        s.add(2,7);
        s.add(6,7);


    }
}
