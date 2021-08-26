import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static kotlin.reflect.jvm.internal.impl.utils.DFS.dfs;

public class Sequence {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> seq(int n){
        boolean[] visit =new boolean[n + 1];

        ArrayList<Integer> path = new ArrayList<>();

        dfs(path,0, n, visit);

        return ans;
    }
    public void dfs( ArrayList<Integer> path, int num, int input, boolean[] visit){

        ans.add(new ArrayList<>(path));

        for(int i = 1; i <= input; i++) {
            if(!visit[i]) {
                visit[i] = true;
                path.add(i);
                dfs(path,num+1,input,visit);
                path.remove(path.size() - 1);
                visit[i] = false;
            }
        }


    }

    public static void main(String[] args) {
        Sequence s = new Sequence();

        System.out.println(s.seq(3));
    }
}
