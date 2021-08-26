import java.util.*;

public class dfs {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] visit = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,ans,path);
        for(List<Integer> list : ans){
            for(int i : list){
                System.out.println(i);
            }
        }
    }
    public static void dfs(int[] candidates, int target , int sum, int num,List<List<Integer>> ans,Deque<Integer> path){
        if(candidates[num] > target){
            return;
        }
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(num == candidates.length && sum != target){
            return;
        }
        for(int i = num; i < candidates.length; i++){
            if(i > num && candidates[i] == candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates,target,sum + candidates[i], i+1,ans,path);
            path.removeLast();
        }
        return;
    }
}
