package 堆;

import 堆.printer.BinaryTreeInfo;
import 堆.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Integer[] ints = new Integer[1000];
//        for (int i = 0;i <1000;i++){
//            ints[i] = i;
//        }
//        BinaryHeap<Integer> binaryHeap = new BinaryHeap<Integer>(ints);
//        System.out.println(binaryHeap.get());
//        Person 一 = new Person("一", 1);
//        Person 二 = new Person("二", 2);
//        Person 三 = new Person("三", 3);
//        Person 四 = new Person("四", 4);
//        Person 五 = new Person("五", 5);
//        Person 六 = new Person("六", 6);
        Person 七 = new Person("七", 7);
        Person 八 = new Person("八", 7);
        Person 九 = new Person("九", 8);
        PriorityQueue<Person> personPriorityQueue = new PriorityQueue<>(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                int com = ((Person) o1).getCritical() - ((Person) o2).getCritical();
                return com;
            }
        });
//        personPriorityQueue.enQueue(一);
//        personPriorityQueue.enQueue(二);
//        personPriorityQueue.enQueue(三);
//        personPriorityQueue.enQueue(四);
//        personPriorityQueue.enQueue(五);
//        personPriorityQueue.enQueue(六);
        personPriorityQueue.enQueue(七);
        personPriorityQueue.enQueue(八);
        personPriorityQueue.enQueue(九);
        while (true){
            System.out.println(personPriorityQueue.deQueue());
        }
    }
}
