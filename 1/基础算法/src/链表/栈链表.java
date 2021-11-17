package 链表;

public class 栈链表 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 1;i<=110;i++){
            stringStack.push(String.valueOf(i));
        }
        for (int i = 1;i<=110;i++){
            System.out.println(stringStack.pop());
        }

    }
}
class Stack<Item>{
    private int N;
    private Node first;
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
    public void push(Item it){
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
        first.item = it;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
