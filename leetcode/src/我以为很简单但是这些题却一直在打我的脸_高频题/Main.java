package 我以为很简单但是这些题却一直在打我的脸_高频题;

public class Main {
    public static void main(String[] args) {
        LRUcache<Integer, Integer> integerIntegerLRUcache = new LRUcache<>(5);
        integerIntegerLRUcache.put(1,1);
        integerIntegerLRUcache.put(2,2);
        integerIntegerLRUcache.put(3,3);
        integerIntegerLRUcache.put(4,4);
        integerIntegerLRUcache.put(5,5);
        integerIntegerLRUcache.get(1);
        integerIntegerLRUcache.put(6,6);
        integerIntegerLRUcache.put(3,3);
        integerIntegerLRUcache.put(7,7);
        System.out.println(integerIntegerLRUcache.getMap());

    }
}
