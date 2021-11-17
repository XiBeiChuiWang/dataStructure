public class 汉诺塔 {
    public void han1(int n,String p1,String p2,String p3){
        if (n == 1){
            move(n,p1,p3);
            return;
        }
        han1(n - 1,p1,p3,p2);
        move(n,p1,p3);
        han1(n - 1,p2,p1,p3);
    }
    private void move(int no,String from,String to){
        System.out.println(no+"   "+from +" -> "+to);
    }

    public static void main(String[] args) {
        汉诺塔 h = new 汉诺塔();
        h.han1(5,"a","b","c");
    }
}
