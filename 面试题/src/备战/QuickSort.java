package 备战;

import java.util.Comparator;

public class QuickSort<V> {
    private Comparator comparator;

    public QuickSort() {
    }

    public QuickSort(Comparator comparator) {
        this.comparator = comparator;
    }

    private int compare(V v1,V v2){
        if (comparator != null){
            return comparator.compare(v1,v2);
        }else {
            return ((Comparable) v1).compareTo(v2);
        }
    }

    private void swap(V[] vs ,int a,int b){
        V v = vs[a];
        vs[a] = vs[b];
        vs[b] = v;
    }

    public V[] sort(V[] vs){
        sort(vs,0,vs.length);
        return vs;
    }

    public void sort(V[] vs,int begin,int end){
        if (end - begin < 2) return;
        int mid = point(vs, begin, end);
        sort(vs,begin,mid);
        sort(vs,mid + 1,end);
    }

    public int point(V[] vs,int begin,int end) {
        int random = (int) ( begin + ((end - begin) * Math.random()));
        swap(vs,random,begin);
        V v = vs[begin];
        end--;

        while (begin < end){

            while (begin < end){
                if (compare(v,vs[end]) > 0){
                    vs[begin++] = vs[end];
                    break;
                }else {
                    end--;
                }
            }

            while (begin < end){
                if (compare(v,vs[begin]) < 0){
                    vs[end--] = vs[begin];
                    break;
                }else {
                    begin++;
                }
            }
        }

        vs[begin] = v;
        return begin;
    }

    public Integer[] a1(Integer[] integers){
        a(integers);
        return integers;
    }
    public void a(Integer[] integers){
        integers[0] = 0;
    }
    public static void main(String[] args) {
        QuickSort<Integer> integerQuickSort = new QuickSort<>();
        Integer[] sort = integerQuickSort.sort(new Integer[]{5, 4, 0,3, 2, 1});
        for (Integer i:sort
             ) {
            System.out.print(i+"  ");
        }
    }
}
