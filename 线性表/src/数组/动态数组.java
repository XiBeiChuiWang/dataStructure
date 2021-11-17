package 数组;


import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

//Dynamic Array
public class 动态数组 <E>{
    public E[] a = (E[]) new java.lang.Object[10];
    private int n;

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public boolean contains(E aa){
        for (int i = 0;i < n;i++){
            if (a[i] == aa){
                return true;
            }
        }
        return false;
    }

    public void add(E element){
        if (n == a.length){
            expansion(2 * n);
        }
        a[n] = element;
        n++;
    }

    public void add(int index,E element){
        if (n == a.length){
            expansion(2 * n);
        }

        for (int i = n;i >= index;i--){
            a[i] = a[i-1];
        }
        a[index-1] = element;
        n++;
    }

    public E remove(int index){

        E b = a[index-1];
        for (int i = index-1;i<n-1;i++){
            a[i] = a[i+1];
        }
        n--;
        return b;
    }


    public E get(int index){
        return a[index - 1];
    }

    public void set(int index,E element){
        a[index - 1] = element;
    }

    public  void clear(){
        n = 0;
    }

    public void expansion(int e){
        E[] ints = (E[]) new Object[e];
        for (int i = 0;i < a.length;i++){
            ints[i] = a[i];
        }
        a = ints;
    }

    public static void main(String[] args) {
        动态数组<String> a = new 动态数组<>();
//        a.add("dasdasd");
//        a.add("123");

        for (int i = 0;i < 10000;i++){
            a.add(String.valueOf(i));
        }
        System.out.println(a.get(2));
//        a.remove(2);
//        System.out.println(a.contains("123"));
        System.out.println(a.size());

ArrayList
    }
}
