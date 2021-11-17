package alibaba;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _815_公交路线 {

    private HashMap<Integer, Set<Integer>> integerSetHashMap = null;
    private int min = Integer.MAX_VALUE;
    boolean[] booleans = null;

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        if (routes == null || routes.length == 0 || routes[0].length == 0) return -1;
        booleans = new boolean[routes.length];
        integerSetHashMap = new HashMap<>();

        for (int i = 0;i < routes.length;i++){
            for (int j = 0;j < routes[i].length;j++){
                Set set = integerSetHashMap.get(routes[i][j]);
                if (set == null){
                    HashSet<Integer> hashSet = new HashSet();
                    hashSet.add(i);
                    integerSetHashMap.put(routes[i][j],hashSet);
                }else {
                    set.add(i);
                }
            }
        }
        for (int i = 0;i < routes.length;i++){
            for (int j = 0;j < routes[i].length;j++){
                if (source == routes[i][j]){
                    back(routes,target,i,1);
                }
            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    private void back(int[][] routes, int target,int car_index,int car_count){
        Set<Integer> integers = integerSetHashMap.get(target);
        if (integers.contains(car_index)){
            min = Math.min(min,car_count);
            return;
        }

        booleans[car_index] = true;

        for (int i = 0;i < routes[car_index].length;i++){
            Set<Integer> integers1 = integerSetHashMap.get(routes[car_index][i]);
            for (int j:integers1){
                if (!booleans[j]){
                    back(routes,target,j,car_count+1);
                }
            }
        }
        booleans[car_index] = false;
    }

    public static void main(String[] args) {
        System.out.println(new _815_公交路线().numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }
}