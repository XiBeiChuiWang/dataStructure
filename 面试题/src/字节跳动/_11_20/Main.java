package 字节跳动._11_20;

public class Main {
    public static void main(String[] args) {
        _12_146_LRU缓存机制 lru缓存机制 = new _12_146_LRU缓存机制(5);
        lru缓存机制.put(1,1);
        lru缓存机制.put(2,2);
        lru缓存机制.put(3,3);
        lru缓存机制.put(4,4);
        lru缓存机制.put(5,5);
        lru缓存机制.put(6,6);
        System.out.println(lru缓存机制.get(2));
    }
}
