package alibaba;

public class B {

    public static void main(String[] args) {
        System.out.println(new B().d(new int[]{3,3,3,3,3,3,3,3,3,3,3,3}));
    }
    private int ans = Integer.MAX_VALUE;

    public int d(int[] ints){
        dfs(ints,0);
        return ans;
    }


    public void dfs(int[] ints,int count){

        if (count > ans){
            return;
        }

        if (check(ints)){
            ans = count;
        }


        for (int i = 0;i < ints.length;i++) {
            if (ints[i] == 0)
                continue;

            if (ints[i] > 0){
                ints[i]--;
                dfs(ints,count+1);
                ints[i]++;
            }

            if (ints[i] > 1){
                ints[i] -= 2;
                dfs(ints,count+1);
                ints[i] += 2;
            }

            if (i > 1 && ints[i - 1] > 0 && ints[i - 2] > 0 && ints[i] > 0){
                ints[i]--;
                ints[i - 1]--;
                ints[i - 2]--;
                dfs(ints,count+1);
                ints[i]++;
                ints[i - 1]++;
                ints[i - 2]++;
            }

            if (i > 3 &&ints[i - 1] > 0 && ints[i - 2] > 0 &&ints[i - 3] > 0 && ints[i - 4] > 0 && ints[i] > 0){
                ints[i]--;
                ints[i - 1]--;
                ints[i - 2]--;
                ints[i - 3]--;
                ints[i - 4]--;
                dfs(ints,count+1);
                ints[i]++;
                ints[i - 1]++;
                ints[i - 2]++;
                ints[i - 3]++;
                ints[i - 4]++;
            }

            if (i > 1 && ints[i - 1] > 1 && ints[i - 2] > 1 && ints[i] > 1){
                ints[i]-=2;
                ints[i - 1]-=2;
                ints[i - 2]-=2;
                dfs(ints,count+1);
                ints[i]+=2;
                ints[i - 1]+=2;
                ints[i - 2]+=2;
            }
        }
    }

    private boolean check(int[] ints){
        boolean b = true;
        for (int i = 0;i < ints.length;i++){
            if (ints[i] != 0){
                b = false;
            }
        }
        return b;
    }
}
