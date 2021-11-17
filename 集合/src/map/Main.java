package map;

import file.FileInfo;
import file.Files;
import map.printer.BinaryTreeInfo;
import map.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        TreeMap<Integer, Integer> integerStringTreeMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        for (int i = 0;i< 100;i++) {
//            integerStringTreeMap.put(i, i);
//        }
//
//        integerStringTreeMap.traversal(new Map.Visitor() {
//            @Override
//            boolean visit(Object key, Object value) {
//                System.out.println(key+"_"+value);
//
//                return false;
//            }
//        });
        Person a = new Person("a", 1);
        Person b = new Person("b", 1);
        Person c = b;
        HashMap<Object,Object > personIntegerHashMap = new HashMap<Object, Object>();
        for (int i = 1;i<=200;i++){
            personIntegerHashMap.put(new KK(i),i);
        }
        System.out.println(personIntegerHashMap.get(new KK(1)));
//        personIntegerHashMap.put(a,1);
//        personIntegerHashMap.put(b,2);
//        personIntegerHashMap.put(null,1);
//        personIntegerHashMap.put("jack",2);
//        System.out.println(personIntegerHashMap.containsValue(1));
//        System.out.println(personIntegerHashMap.containsValue(2));
//        //personIntegerHashMap.remove("jack");
//        personIntegerHashMap.traversal(new Map.Visitor<Object, Integer>() {
//            @Override
//            boolean visit(Object key, Integer value) {
//                System.out.println(key+"_"+value);
//                return false;
//            }
//        });
        personIntegerHashMap.print();



    }
}
