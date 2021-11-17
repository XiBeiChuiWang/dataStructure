package 回溯;
import java.util.ArrayList;
import java.util.List;

public class _51_N皇后 {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return null;
        ArrayList<List<String>> lists = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        int[] ints = new int[n];
        backtrack(list,ints,lists);
        return lists;
    }

    private void backtrack(ArrayList<String> list,int[] ints,ArrayList<List<String>> lists){
        if (list.size() == ints.length){
            lists.add(new ArrayList<String>(list));
        }

        for (int i = 0;i < ints.length;i++){
            if (!isPlace(list.size(),i,ints)){
                continue;
            }
            String s = "";
            for (int j = 0;j < i;j++){
                s += ".";
            }
            s += "Q";
            for (int j = i;j < ints.length - 1;j++){
                s += ".";
            }
            list.add(s);
            ints[list.size() - 1] = i;
            backtrack(list, ints, lists);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPlace(int row,int col,int[] ints){
        for (int i = 0;i < row;i++){
            if (ints[i] == col) return false;
            if ((row - i) == Math.abs(col - ints[i])) return false;
        }
        return true;
    }
}
