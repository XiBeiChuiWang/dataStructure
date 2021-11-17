package union_find;

public class Test {
    public static void main(String[] args) {
        加权Quick_union quick_find = new 加权Quick_union(100);
        加权Quick_union quick_union = new 加权Quick_union(100);
        quick_union.union(1,2);
        quick_union.union(1,3);
        System.out.println(quick_union.connectde(2,3));
        System.out.println(quick_union.connectde(2,4));
        quick_union.union(2,4);
        System.out.println(quick_union.connectde(2,4));
        System.out.println(quick_union);
    }
}
