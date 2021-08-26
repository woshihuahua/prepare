import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Freq {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,4,4,4,5,5,5,5,5,6,6,6,6,6,6};
        int k = 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums ){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int[][] stat = new int[map.entrySet().size()][2];
        int ind = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            stat[ind][0] = entry.getKey();
            stat[ind][1] = entry.getValue();
            ind++;
        }
        Arrays.sort(stat,(a,b)->b[1] - a[1]);
        for(int i = 0 ; i < k; i++){
            System.out.println(stat[i][0]);
        }

    }
}
