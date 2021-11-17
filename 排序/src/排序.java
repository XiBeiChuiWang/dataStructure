

import tools.Person;

import java.util.Comparator;
import java.util.Objects;

public class 排序<E> {

    private Comparator comparator;
    private E [] e;
    int swapCount = 0;
    int comCount = 0;
    public 排序(E[] e,Comparator comparator) {
        this.e = e;
        this.comparator = comparator;
        this.heapSize = e.length;
        leftArray = new Object[e.length >> 1];
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public void setE(E[] e) {
        this.e = e;
    }

    public 排序(E[] e) {
        this.e = e;
        this.heapSize = e.length;
        leftArray = new Object[e.length >> 1];
    }

    private int compare(E e1, E e2){
        return comparator == null ? ((Comparable)e1).compareTo(e2) : comparator.compare(e1,e2);
    }

    private void swap(int a,int b){
        E e1 = e[a];
        e[a] = e[b];
        e[b] = e1;
    }

    public void print(){
        for (E e1: e
             ) {
            System.out.print(e1+"_");
        }
    }

    //冒泡排序
    public E[] 冒泡排序(){
        swapCount = 0;
        comCount = 0;
        for (int end = e.length-1;end > 0;end--){
            //如果所有元素都已排好
            int sorted = 1;
            for (int begin = 1;begin <= end;begin++){
                comCount++;
                if (compare(e[begin-1],e[begin]) > 0){
                    swap(begin-1,begin);
                    sorted = begin;
                    swapCount++;
                } 
            }
            end = sorted;
        }
        System.out.println("冒泡排序交换次数："+swapCount);
        System.out.println("冒泡排序比较次数："+comCount);
        return e;
    }
    //选择排序
    public E[] 选择排序(){
        swapCount = 0;
        comCount = 0;
        for (int end = e.length- 1;end > 0;end--){
            //如果所有元素都已排好
            int max = 0;
            int begin = 1;
            for (;begin <= end;begin++){
                comCount++;
                if (compare(e[begin],e[max]) >= 0){
                   max = begin;
                }
            }
            comCount++;
            if (compare(e[max],e[begin-1])>0) {
                swap(max,end);
                swapCount++;
            }

        }
        System.out.println("选择排序交换次数："+swapCount);
        System.out.println("选择排序比较次数："+comCount);
        return e;
    }

    //堆排序
    private int heapSize;

    public E[] 堆排序(){
        swapCount = 0;
        //建堆
        // 自下而上的下滤
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize > 1){
            //交换首尾元素
            swap(0,heapSize-1);
            swapCount++;
            //size--
            heapSize--;
            //首元素下滤
            siftDown(0);
        }
        System.out.println("堆排序"+swapCount);
        return e;
    }

    private void siftDown(int index) {
        E element = e[index];
        int half = heapSize >> 1;
        // 第一个叶子节点的索引 == 非叶子节点的数量
        // index < 第一个叶子节点的索引
        // 必须保证index位置是非叶子节点
        while (index < half) {
            // index的节点有2种情况
            // 1.只有左子节点
            // 2.同时有左右子节点

            // 默认为左子节点跟它进行比较
            int childIndex = (index << 1) + 1;
            E child = e[childIndex];

            // 右子节点
            int rightIndex = childIndex + 1;

            // 选出左右子节点最大的那个
            if (rightIndex < heapSize && compare(e[rightIndex], child) > 0) {
                child = e[childIndex = rightIndex];
            }

            if (compare(element, child) >= 0) break;

            // 将子节点存放到index位置
            e[index] = child;
            // 重新设置index
            index = childIndex;
        }
        e[index] = element;
    }

    //插入排序
    public E[] 插入排序(){
        comCount = 0;
        swapCount = 0;
        for (int begin = 1;begin < e.length;begin++){
            E e1 = e[begin];
            int i;
            for (i = begin;i > 0;i--){
                comCount++;
                if (compare(e1,e[i-1])<0){
                    e[i] = e[i-1];
                }else {
                    break;
                }
            }
            if (compare(e1,e[i]) != 0) {
                swapCount++;
                e[i] = e1;
            }
        }
        System.out.println("插入排序赋值次数："+swapCount);
        System.out.println("插入排序比较次数："+comCount);
        return e;
    }

    public E[] 归并排序(){
        归并排序(0,e.length);
        return e;
    }

    private void 归并排序(int begin,int end){
        if ((end - begin) < 2) return;
        int mid = (begin + end) >> 1;
        归并排序(begin,mid);
        归并排序(mid,end);
        merge(begin,mid,end);
    }
    private Object[] leftArray;
    private void merge(int begin,int mid,int end){
        int li = 0 , le = mid - begin;
        int ri = mid , re = end;
        int ai = begin;
        //备份左边数组
        for(int i = li;i < le;i++){
            leftArray[i] = e[begin +i];
        }

        while (li < le){
            if (ri <re && compare((E) leftArray[li],e[ri]) > 0){
                e[ai++] = e[ri++];
            }else {
                e[ai++] = (E) leftArray[li++];
            }
        }
    }

    //快速排序
    public  E[] 快速排序(){
        快速排序(0,e.length);
        return e;
    }

    private  void 快速排序(int begin,int end){
        if (end - begin < 2) return;
        int mid = pointIndex(begin, end);
        快速排序(begin,mid);
        快速排序(mid+1,end);
    }

    private int pointIndex(int begin,int end){

        int v = (int) (begin+(Math.random() * (end - begin)));
        swap(v,begin);
        E e1 = e[begin];
        end--;
        //两个指针
        while (begin < end){

            while (begin < end){
                if (compare(e1,e[end]) > 0){
                    e[begin++] = e[end];
                    break;
                }else {
                    end--;
                }
            }

            while (begin < end){
                if (compare(e1,e[begin]) < 0){
                    e[end--] = e[begin];
                    break;
                }else {
                    begin++;
                }
            }
        }
        //结束后赋值
        e[begin] = e1;
        return begin;
    }

    public void a(int[] s){
        s[0] = 1;
    }

    public static void main(String[] args) {
        Person a = new Person("a", 2);
        Person b = new Person("b", 1);
        Person c = new Person("c", 3);
        排序<Person> person排序 = new 排序<>(new Person[]{a, b, c}, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Person)o2).getAge() - ((Person)o1).getAge();
            }
        });
        Person[] people = person排序.快速排序();
        for (Person p: people) {
            System.out.println(p);
        }
    }
}
