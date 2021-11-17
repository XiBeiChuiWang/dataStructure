package 字节跳动._21_30;

import java.util.ArrayList;
import java.util.List;

public class _29_93_复原IP地址 {
    private final static int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,0);
        return ans;
    }

    private void dfs(String s,int seg_id,int seg_begin){
        if (seg_id == SEG_COUNT){
            if (seg_begin == s.length()){
                StringBuffer ipAddr = new StringBuffer();

                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());

            }
            return;
        }

        if (seg_begin == s.length()){
            return;
        }

        if (s.charAt(seg_begin) == '0'){
            segments[seg_id] = 0;
            dfs(s,seg_id+1,seg_begin+1);
        }

        int addr = 0;
        for (int seg_end = seg_begin;seg_end < s.length();seg_end++){
            addr = addr * 10 + (s.charAt(seg_end) - '0');
            if (addr > 0 && addr <= 0xFF){
                segments[seg_id] = addr;
                dfs(s,seg_id+1,seg_end+1);
            }else {
                break;
            }
        }
    }
}
