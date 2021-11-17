import java.util.Arrays;

public class coin {

    private Integer[] co;

    public coin(Integer[] co) {
        this.co = co;
        Arrays.sort(co);
    }

    public int 暴力枚举(int money){
        if (money < 1){
            return Integer.MAX_VALUE;
        }
        if (money == co[0] || money == co[1] || money == co[2] || money == co[3] ){
            return 1;
        }
        int min1 = Math.min(暴力枚举(money-co[0]),暴力枚举(money-co[1]));
        int min2 = Math.min(暴力枚举(money-co[2]),暴力枚举(money-co[3]));
        int min = Math.min(min1,min2);
        return min + 1;
    }

    public int 备忘录(int money){
        if (money < 1) return -1;
        int[] dp = new int[money+1];
        for (Integer i:co){
            if (money < i){
                break;
            }
            dp[i] = 1;
        }
        return 备忘录(money,dp);
    }
    private int 备忘录(int money,int[] dp){
        if (money < 1){
            return Integer.MAX_VALUE;
        }
        if (dp[money] == 0){
            int min1 = Math.min(备忘录(money - co[0],dp),备忘录(money - co[1],dp));
            int min2 = Math.min(备忘录(money - co[2],dp),备忘录(money - co[3],dp));
            int min = Math.min(min1,min2);
            dp[money] = min + 1;
        }
        return dp[money];
    }

    public int 递推(int money){
        if (money < 1){
            return -1;
        }

        int[] dp = new int[money+1];
        int[] faces = new int[money+1];

        for (int i = 1;i <= money;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < co.length;j++){
                if (i < co[j] || dp[i - co[j]] < 0)
                    continue;
                if (i >= co[j] && dp[i - co[j]] < min){
                    min = dp[i - co[j]];
                    faces[i] = co[j];
                }
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min + 1;
            }
        }
        print(money,faces);
        return dp[money];
    }

    private void print(int money,int[] faces){
        if (money < 1) return;
        System.out.println(faces[money]);
        print((money - faces[money]),faces);
    }
//leetcode 332
    public int coinChange(int[] coins, int amount) {
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];

        for (int i = 1;i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if (i < coins[j] || dp[i - coins[j]] < 0)
                    continue;
                if (i >= coins[j] && dp[i - coins[j]] < min){
                    min = dp[i - coins[j]];
                }
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min + 1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE + 1 ? -1 : dp[amount];
    }
}

