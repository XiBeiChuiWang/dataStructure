package 备战;

import java.util.Comparator;

public class MergeSort<V> {
    private Comparator comparator;

    public MergeSort() {
    }

    public MergeSort(Comparator comparator) {
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
        int mid = (begin + end) >> 1;
        sort(vs, begin, mid);
        sort(vs,mid,end);
        merge(vs,begin,mid,end);
    }

    private Object[] leftArray = null;

    public void merge(V[] vs,int begin,int mid,int end){
        int li = 0 , le = mid - begin;
        int ri = mid , re = end;
        leftArray = new Object[le];
        for (int i = li;i < le;i++){
            leftArray[i] = vs[begin + i];
        }

        while (li < le){
            if (ri < re && compare((V) leftArray[li],vs[ri]) > 0){
                vs[begin++] = vs[ri++];
            }else {
                vs[begin++] = (V) leftArray[li++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort<Integer> integerMergeSort = new MergeSort<>();
        Integer[] sort = integerMergeSort.sort(new Integer[]{5, 4, 0,3, 2, 1});
        for (Integer i:sort
        ) {
            System.out.print(i+"  ");
        }
    }
}
