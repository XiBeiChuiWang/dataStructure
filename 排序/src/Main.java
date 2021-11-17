import tools.Integers;
import tools.Person;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Integer[] random = Integers.random(10000,1, 10000);
        Integer[] random1 = Integers.descOrder(1, 8);
//        排序<Integer> integer = new 排序<Integer>(random,new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return (Integer)o1-(Integer)o2;
//            }
//        });
        排序<Integer> integer1 = new 排序<Integer>(random1,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1-(Integer)o2;
            }
        });
//        Integers.println(random);gui
//        integer.冒泡排序();
        integer1.归并排序();
//        Integers.println(random);
        integer1.print();
//
//        Person a = new Person("a", 1);
//        Person b = new Person("b", 2);
//        Person c = new Person("c", 1);
//        Person d = new Person("d", 1);
//        Person e = new Person("e", 1);
//        Person f = new Person("f", 1);
//        Person[] p = new Person[]{a,b,c,d,e,f};
//        排序<Person> person = new 排序<Person>(p,new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int com = ((Person)o1).getAge()-((Person)o2).getAge();
//                return com;
//            }
//        });
//        person.print();
//        person.快速排序();
//        System.out.println();
//        person.print();
//        Integer[] e1 = Integers.ascOrder(1, 10000);
//        二分搜索<Person> integer二分搜索 = new 二分搜索<Person>(person.e, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int com = ((Person)o1).getAge()-((Person)o2).getAge();
//                return com;
//            }
//        });
//        System.out.println(integer二分搜索.midfind(new Person("f", 1)));
    }
}
