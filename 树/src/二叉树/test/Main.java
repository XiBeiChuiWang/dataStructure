package 二叉树.test;

import 二叉树.AVLTree;
import 二叉树.Person;
import 二叉树.RBTree;
import 二叉树.printer.BinaryTrees;
import 二叉树.二叉搜索树;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        二叉搜索树<Person> 二叉搜索树 = new 二叉搜索树<>(new 二叉搜索树Comparator());
        二叉搜索树.add(new Person("1",1));
        二叉搜索树.add(new Person("1",2));
        二叉搜索树.add(new Person("4",3));
        二叉搜索树.add(new Person("1",4));
        二叉搜索树.add(new Person("1",5));
        二叉搜索树.add(new Person("3",6));
        BinaryTrees.println(二叉搜索树);
////        System.out.println(二叉搜索树.isEmpty());\\
////        二叉搜索树.clear();
////        System.out.println(二叉搜索树.isEmpty());
////        二叉搜索树.Traverse(new Visitor() {
//////            @Override
//////            public boolean visit(Object element) {
////////                System.out.println(element);
////////                return false;
////////            }
//////        });
//        System.out.println(二叉搜索树.node(new Person(null,20)).element);

//    }
//        二叉搜索树<Integer> 二叉搜索树 = new 二叉搜索树<>();
//        for (int i = 0;i<=100_0000;i++){
//            二叉搜索树.add(i);
//        }
//        System.out.println(二叉搜索树.getElement(999999));
//        二叉搜索树.remove(new 二叉搜索树.Node(0,null));

//        BinaryTrees.println(二叉搜索树);
//        System.out.println(二叉搜索树.getElement(10));
//        二叉搜索树.Traverse(new Visitor() {
//            @Override
//            public boolean visit(Object element) {
//                System.out.println(element);
//                return false;
//            }
//        });

//        二叉树.二叉搜索树.Node qianqu = 二叉搜索树.houqu(二叉搜索树.node(5));
//        System.out.println(qianqu.getElement());
//        二叉搜索树.remove(二叉搜索树.node(1));
//        二叉搜索树.remove(二叉搜索树.node(2));
//        二叉搜索树.remove(二叉搜索树.node(3));
//        二叉搜索树.remove(二叉搜索树.node(4));
//        二叉搜索树.remove(二叉搜索树.node(7));
//        二叉搜索树.remove(二叉搜索树.node(6));
//        二叉搜索树.remove(二叉搜索树.node(8));
//        二叉搜索树.remove(二叉搜索树.node(5));
//        BinaryTrees.println(二叉搜索树);
//        HashSet<Person> people = new HashSet<>();
//        Person person = new Person("1", 18);
//        people.add(person);
//        person.setAge(19);
//        System.out.println(people);
    }
}
class 二叉搜索树Comparator implements Comparator<Person> {

    @Override
    public int compare(Person e1, Person e2) {
        return e1.getAge() - e2.getAge();
    }
}
