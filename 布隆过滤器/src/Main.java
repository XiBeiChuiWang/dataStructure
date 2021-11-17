import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        布隆过滤器 布隆过滤器 = new 布隆过滤器(1_0000_0, 0.0001);
        布隆过滤器.put("dasdasdasd");
        System.out.println(布隆过滤器.contains("dasdasdasd"));
    }
}
