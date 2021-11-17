package 基础;

public class 欧几里得 {
    public static int a(int p, int q){
        if(q == 0)
            return p;
        else{
            int r = p % q;
            return a(q, r);
        }
    }

    public static void main(String[] args) {
        System.out.println(a(5,15));;
    }
}
