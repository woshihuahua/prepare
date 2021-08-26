import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Test3{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[3][n];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] =  sc.nextInt();
            }
            Arrays.sort(nums[i]);
        }
        int oneL = 0;
        int twoL = 0;
        int threeL = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(nums[0][oneL] <= nums[1][twoL] && nums[0][oneL] <= nums[2][threeL]){
                res+= nums[0][oneL];
                oneL++;

            }else if(nums[1][twoL] <= nums[0][oneL] && nums[1][twoL] <= nums[2][threeL]){
                res+= nums[1][twoL];
                twoL++;

            }else if(nums[2][threeL] <= nums[0][oneL] && nums[2][threeL] <= nums[1][twoL]){
                res+= nums[2][threeL];
                threeL++;

            }
        }
        System.out.println(res);

    }
}
