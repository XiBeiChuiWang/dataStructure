package union_find;

public class Quick_find {
    private int[] id ;

    public Quick_find(int a) {
        id = new int[a];
        for (int i = 0;i < a;i++){
            id[i] = i;
        }
    }
    public int find(int a){
        return id[a];
    }
    public boolean union(int a,int b){
        int aID = find(a);
        int bID = find(b);
        if (aID == bID){
            return false;
        }else{
            for(int i = 0;i<id.length;i++){
                if (id[i] == aID){
                    id[i] = bID;
                }
            }
            return true;
        }
    }
    public void connectde(int a,int b){
        if (id[a] == id[b]){
            System.out.println("连通");
        }else{
            System.out.println("不连通");
        }

    }
}
