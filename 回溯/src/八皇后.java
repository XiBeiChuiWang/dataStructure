import java.util.Map;

public class 八皇后 {
    int a[];
    int ways;
    public void empress(int n){
        a = new int[n];
        place(0);

        System.out.println("一共有"+ways);
    }

    private void place(int row) {
        if (row == a.length) {
            for (int i : a) {
                System.out.print(i + "__");
            }
            System.out.println();
            ways++;
            return;
        }
        for (int col = 0; col < a.length; col++) {
            if (isValid(row, col)) {
                a[row] = col;
                place(row + 1);
            }
        }
    }

    //判断是否可放
    private boolean isValid(int row,int col){
        for (int i = 0;i < row;i++){
            if (a[i] == col) return false;
            if ((row - i) == Math.abs(col - a[i])) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        new 八皇后().empress(12);
    }
}
