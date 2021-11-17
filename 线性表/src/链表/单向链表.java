package 链表;

public class 单向链表 <E>{
    private int n;
    private Node first = new Node(null,null);
    private class Node{
        Node next;
        E element;

        public Node(Node next, E element) {
            this.next = next;
            this.element = element;
        }
    }
    private Node node(int index){
        Node node = first;
        for (int i = 1;i<=index;i++){
            node = node.next;
        }
        return node;
    }

    public int size(){
        return n;
    }

    public void add(E element){
        if (n == 0){
            first.next = new Node(null,element);
        }else {
            node(n).next = new Node(null,element);
        }
        n++;
    }

    public void add(int index,E element){
        if (index == 1){
            first.next = new Node(first.next,element);
        }else {
            Node lnode = node(index - 1);
            lnode.next = new Node(lnode.next,element);
        }
        n++;
    }

    public E remove(int index){
        E ele = node(index).element;
        if (index == 1){
            first.next = first.next.next;
        }else{
            Node node = node(index - 1);
            node.next = node.next.next;
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
        单向链表<Integer> s = new 单向链表<Integer>();
        for (int i = 1;i<=100;i++){
            s.add(i);
        }
        Integer remove = s.remove(99);
        System.out.println(remove);

    }
}
