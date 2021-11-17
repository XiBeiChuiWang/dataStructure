package union_find;

import java.util.Arrays;

public class 加权Quick_union {
    private int[] id ;
    private int[] sz;

    public 加权Quick_union(int a) {
        id = new int[a];
        sz = new int[a];
        for (int i = 0;i < a;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }
    public int find(int a){
        while (a != id[a]){
            a = id[a];
        }
        return a;
    }
    public void union(int a,int b){
        int aID = find(a);
        int bID = find(b);
        if (sz[aID] < sz[bID]){
            id[aID] = bID;
            sz[bID] += sz[aID];
        }else{
            id[bID] = aID;
            sz[aID] += sz[bID];
        }
    }
    public boolean connectde(int a,int b){
        int aID = find(a);
        int bID = find(b);
        return (aID == bID);
    }
}
