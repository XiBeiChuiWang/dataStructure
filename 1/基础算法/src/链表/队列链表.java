package 链表;

public class 队列链表 {
    public static void main(String[] args) {
        Queue<String> stringStack = new Queue<String>();
        for (int i = 1;i<=100;i++){
            stringStack.enqueue(String.valueOf(i));
        }
        stringStack.bianli();
        for (int i = 1;i<=100;i++){
            System.out.println(stringStack.dequeue());
        }
        stringStack.bianli();

    }
}
class Queue<Item>{
    private int N;
    private Node first;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item it){
        Node oldlast = last;
        last = new Node();
        last.item = it;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else {
            oldlast.next = last;
        }
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }
    public void bianli(){
        for (Node x = first;x != null;x = x.next){
            System.out.println(x.item);
        }
    }
}
