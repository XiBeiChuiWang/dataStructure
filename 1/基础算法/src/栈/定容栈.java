package 栈;

public class 定容栈 {
    public static void main(String[] args) {
        a1 a = new a1(10);
        for (int i = 0;i<=10;i++){
            a.push(String.valueOf(i));
        }
        for (int i = 0;i<=10;i++){
            System.out.println(a.pop());
        }

    }

}
class a1{
    private String s[];
    private int N = 0;        //size
    public a1(int a) {
        s = new String[a];
    }
    public boolean isEmpty(){
        return (N==0);
    }
    public String pop(){
        if(!isEmpty()){
            return s[--N];
        }else{
            return "栈为空";
        }
    }
    public void push(String item){
        if(N == s.length){
            System.out.println("栈已满");
        }else{
            s[N++] = item;
        }
    }
}
