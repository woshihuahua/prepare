import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tritree {
    static class TreeNode{
        TreeNode mid;
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode mid, TreeNode right){
            this.val = val;
            this.mid = mid;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7,node5,node4,node3);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9,node8,node7,node6);
        node3.left = node2;
        node3.right = node1;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node9);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = queue.size() - 1; i>=0; i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.mid != null){
                    queue.add(node.mid);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        System.out.println(ans);
    }

}
