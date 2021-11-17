package 字节跳动._71_80;

import java.util.ArrayList;

public class _73_6_Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0;i < numRows;i++){
            stringBuilders.add(new StringBuilder());
        }

        boolean b = false;
        int cow = 0;

        for (int i = 0;i < s.length();i++){
            if (cow == 0 || cow == numRows - 1){
                b = !b;
            }

            stringBuilders.get(cow).append(s.charAt(i));

            cow += b ? 1 : -1;
        }
        String ss = "";
        for (int i = 0;i < numRows;i++){
            ss += stringBuilders.get(i).toString();
        }
        return ss;
    }
}
