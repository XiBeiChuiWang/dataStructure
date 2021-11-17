package 瞎看;

public class _面试题_16_10_生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] ints = new int[102];

        for (int i = 0; i < birth.length; i++) {
            ints[birth[i] - 1900]++;
        }
        for (int i = 0; i < death.length; i++) {
            ints[death[i] - 1900 + 1]--;
        }

        int max = 0;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            count += ints[i];
            if (count > max) {
                max = count;
                ans = i;
            }
        }
        return ans + 1900;
    }

}
