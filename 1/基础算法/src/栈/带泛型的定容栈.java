package 栈;

import java.util.Iterator;

public class 带泛型的定容栈 {
    public static void main(String[] args) {
        F<String> stringF = new F<>(10);
        for (int i = 1;i<=10;i++){
            stringF.push(String.valueOf(i));
        }
        for (int i = 1;i<=10;i++){
            System.out.println(stringF.pop());
        }
    }
}
class F<Item>{
    private Item [] a;
    private int N;
    public F(int aa){
        a = (Item[]) (new Object [aa]);
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        if(N < a.length){
            a[N++] = item;
        }else{
            System.out.println("栈满");
        }
    }
    public Item pop(){
        if(!isEmpty()){
            return a[--N];
        }else {
            System.out.println("栈空");
            return null;
        }
    }
}
