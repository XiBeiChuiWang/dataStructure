package union_find;

public class Quick_union {
    private int[] id ;

    public Quick_union(int a) {
        id = new int[a];
        for (int i = 0;i < a;i++){
            id[i] = i;
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
        id[aID] = bID;
    }
    public boolean connectde(int a,int b){
        int aID = find(a);
        int bID = find(b);
        return (aID == bID);
    }
}
