import java.util.*;

public class exam12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] input = new int[num];
//        boolean[] visit = new boolean[num];
        List<Integer> path = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < num; i++){
            input[index++] = sc.nextInt();
        }
        for(int a: input){
            System.out.println(a);
        }
//        int[] arr = {1,1,2};
//        List<List<Integer>> ans = permuteUnique(arr);
//        for(List<Integer> list : ans){
//            for(int a:list){
//                System.out.print(a + ' ');
//            }
//        }


    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(ans,list,visit,nums,0);
        return ans;
    }
    public static void dfs(List<List<Integer>> ans, Deque<Integer> list, boolean[] visit, int[] nums, int length){
        if(length == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i] && !visit[i-1]){
                continue;
            }
            if(!visit[i]){
                visit[i] = true;
                list.addLast(nums[i]);
                dfs(ans,list,visit,nums,length + 1);
                list.removeLast();
                visit[i] = false;
            }
        }
    }
}
