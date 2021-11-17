package 栈;

import java.util.Stack;

public class 不定容栈 {
    public static void main(String[] args) {
        BF<String> stringF = new BF<String>(10);
        for (int i = 1;i<=110;i++){
            stringF.push(String.valueOf(i));
            System.out.println("pushsize"+stringF.rong());
        }
        for (int i = 1;i<=110;i++){
            System.out.println(stringF.pop());
            System.out.println("popsize"+stringF.rong());
        }
    }
}
class BF<Item>{
    private Item [] a;
    private int N;
    public BF(int aa){
        a = (Item[]) (new Object [aa]);
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public int rong(){
        return a.length;
    }
    public void push(Item item){
        if(N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;

    }
    public Item pop(){
        if (N>0&&N < a.length/4){
            resize(a.length/2);
        }
        if(!isEmpty()){
            return a[--N];
        }else {
            System.out.println("栈空");
            return null;
        }
    }
    public void resize(int max){
        Item [] temp = (Item[]) (new Object [max]);
        for(int i = 0;i < N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
}
