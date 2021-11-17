package 堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class PriorityQueue<E> {
    private BinaryHeap<E> binaryHeap;
    private Comparator<E> comparator;

    public PriorityQueue(Comparator comparator) {
        this.comparator = comparator;
        binaryHeap = new BinaryHeap<E>(comparator);
    }

    public PriorityQueue() {
        binaryHeap = new BinaryHeap<E>();
    }

    public int size() {
        return binaryHeap.size();
    }

    public boolean isEmpty() {
        return binaryHeap.isEmpty();
    }

    public void clear() {
        binaryHeap.clear();
    }

    public void enQueue(E element) {
        binaryHeap.add(element);
    }

    public E deQueue() {
        return binaryHeap.remove();
    }

    public E front() {
        return binaryHeap.get();
    }


}
