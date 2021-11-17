import java.util.Arrays;
import java.util.Comparator;

public class 硬币 {
    Integer[] coin;

    public 硬币(Integer[] coin) {
        this.coin = coin;
    }

    public void change(int money){
        Comparator<Integer> integerIntegerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Arrays.sort(coin,integerIntegerComparator);
        int i = 0;
        int coins = 0;
        while (i < coin.length){
            if (money < coin[i]){
                i++;
                continue;
            }
            System.out.println(coin[i]);
            money -= coin[i];
            coins++;
        }
        System.out.println(coins);
    }
}
