package 字节跳动._11_20;

public class _20_7_整数反转 {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int prev = x % 10;
            int pr = ans;
            ans = ans *10 + prev;
            x = x / 10;

            if ((ans - prev) / 10 != pr){
                return 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));

    }
}
