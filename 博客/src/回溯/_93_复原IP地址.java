package 回溯;

import java.util.ArrayList;
import java.util.List;

public class _93_复原IP地址 {

    int[] ints = new int[4];
    ArrayList<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0,0);
        return list;
    }

    private void backtrack(String s,int count,int k){
        if (count == 4){
            if (k == s.length()){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0;i < 4;i++){
                    stringBuilder.append(ints[i]+".");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                list.add(stringBuilder.toString());
            }
            return;
        }

        if (k == s.length()){
            return;
        }

        if (s.charAt(k) == '0'){
            ints[count] = 0;
            backtrack(s, count+1, k+1);
        }

        int addr = 0;
        for (int seg_end = k;seg_end < s.length();seg_end++){
            addr = addr * 10 + (s.charAt(seg_end) - '0');
            if (addr > 0 && addr <= 0xFF){
                ints[count] = addr;
                backtrack(s, count + 1, seg_end + 1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _93_复原IP地址().restoreIpAddresses("010010"));
    }
}
