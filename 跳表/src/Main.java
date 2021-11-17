public class Main {
    public static void main(String[] args) {
        跳表<Integer, String> integerString跳表 = new 跳表<>();
        integerString跳表.put(2,"c");
        integerString跳表.put(1,"a");
        integerString跳表.put(1,"b");
        System.out.println(integerString跳表.get(1));
        System.out.println(integerString跳表.get(2));


    }
}
