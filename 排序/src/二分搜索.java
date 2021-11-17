import java.util.Comparator;

public class 二分搜索 <E>{
    private Comparator comparator;
    E [] e;
    public 二分搜索(E[] e,Comparator comparator) {
        this.e = e;
        this.comparator = comparator;
    }

    public 二分搜索(E[] e) {
        this.e = e;
    }

    private int compare(E e1, E e2){
        return comparator == null ? ((Comparable)e1).compareTo(e2) : comparator.compare(e1,e2);
    }
    public int midfind(E element){
        int begin = 0;
        int end = e.length;
        int mid;
        while (begin < end){
            mid = (begin+end)/2;
            int com = compare(element,e[mid]);
            if (com == 0){
                return mid;
            }else if (com > 0){
                begin = mid + 1;
                continue;
            }else {
                end = mid;
                continue;
            }
        }
        return -1;
    }
}
