package 字节跳动._21_30;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_215_数组中的第K个最大元素 {
    //使用java中的队列 priorityQueue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0;i < nums.length;i++){
            priorityQueue.add(nums[i]);
        }

        for (int i = 1;i <= k - 1;i++){
            priorityQueue.poll();
        }
        return (int) priorityQueue.poll();
    }

    //使用自定义堆 （批量建堆）
    public int findKthLargest1(int[] nums, int k) {
        Integer[] numsi = new  Integer[nums.length];
        for (int i = 0;i < nums.length;i++){
            numsi[i] = nums[i];
        }
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<Integer>(numsi);

        for (int i = 1;i <= k - 1;i++){
            binaryHeap.remove();
        }

        return binaryHeap.remove();
    }



    private static class BinaryHeap<E> {
        private int size;
        private E table[];
        private Comparator comparator;
        private static final int DEFAULT_CAPACITY = 10;

        public BinaryHeap(Comparator comparator) {
            table = (E[]) new Object[DEFAULT_CAPACITY];
            this.comparator = comparator;
        }

        public BinaryHeap() {
            table = (E[]) new Object[DEFAULT_CAPACITY];
        }
        public BinaryHeap(E[] elements, Comparator comparator)  {
            this.comparator = comparator;
            if (elements == null || elements.length == 0) {
                this.table = (E[]) new Object[DEFAULT_CAPACITY];
            } else {
                size = elements.length;
                int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
                this.table = (E[]) new Object[capacity];
                for (int i = 0; i < elements.length; i++) {
                    this.table[i] = elements[i];
                }
                heapify();
            }
        }

        public BinaryHeap(E[] elements)  {
            this(elements,null);
        }
        private void heapify() {
            // 自下而上的下滤
            for (int i = (size >> 1) - 1; i >= 0; i--) {
                siftDown(i);
            }
        }


        public int size() {
            return size;
        }


        public boolean isEmpty() {
            return size == 0;
        }


        public void clear() {
            emptyCheck();
            size = 0;
            for (int i = 0;i < size;i++){
                table[i] = null;
            }
        }


        public void add(E element) {
            if (element == null)
                throw new RuntimeException("添加元素不能为空");
            if (size == table.length){
                expansion(2 * size);
            }
            if (size == 0){
                table[0] = element;
                size++;
                return;
            }
            table[size] = element;
            siftUp(size);
            size++;
        }
        private void siftUp(int index){
            E e = table[index];
            while (index > 0){
                int pindex = (index-1) >> 2;
                E p = table[pindex];
                if (compare(p,e) >= 0) return;
                table[index] = table[pindex];
                index = pindex;
            }
            table[index] = e;
        }

        public E get() {
            emptyCheck();
            return table[0];
        }


        public E remove() {
            emptyCheck();

            int lastIndex = --size;
            E root = table[0];
            table[0] = table[lastIndex];
            table[lastIndex] = null;
            siftDown(0);
            return root;
        }

        private void siftDown(int index) {
            E element = table[index];
            int half = size >> 1;
            // 第一个叶子节点的索引 == 非叶子节点的数量
            // index < 第一个叶子节点的索引
            // 必须保证index位置是非叶子节点
            while (index < half) {
                // index的节点有2种情况
                // 1.只有左子节点
                // 2.同时有左右子节点

                // 默认为左子节点跟它进行比较
                int childIndex = (index << 1) + 1;
                E child = table[childIndex];

                // 右子节点
                int rightIndex = childIndex + 1;

                // 选出左右子节点最大的那个
                if (rightIndex < size && compare(table[rightIndex], child) > 0) {
                    child = table[childIndex = rightIndex];
                }

                if (compare(element, child) >= 0) break;

                // 将子节点存放到index位置
                table[index] = child;
                // 重新设置index
                index = childIndex;
            }
            table[index] = element;
        }


        public E replace(E element) {
            E root = null;
            if (size == 0) {
                table[0] = element;
                size++;
            } else {
                root = table[0];
                table[0] = element;
                siftDown(0);
            }
            return root;
        }

        private void emptyCheck(){
            if (size == 0){
                throw new RuntimeException("堆为空");
            }
        }

        private int compare(E e1, E e2){
            return comparator != null ? comparator.compare(e1,e2) : ((Comparable<E>)e1).compareTo(e2);
        }
        public E gete(int index){
            return table[index];
        }
        private void expansion(int e){
            E[] ints = (E[]) new Object[e];
            for (int i = 0;i < size;i++){
                ints[i] = table[i];
            }
            table = ints;
        }

    }
}
