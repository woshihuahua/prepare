public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param m int整型
     * @param a ListNode类 指向彩带的起点，val表示当前节点的val，next指向下一个节点
     * @return ListNode类一维数组
     */
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode[] solve (int m, ListNode a) {
        // write code here
        ListNode[] ans = new ListNode[m];
        int num = 0;
        ListNode b = a;
        while(a != null){
            a = a.next;
            num++;
        }
        int[] input = new int[num];
        int index =0;
        while(b != null){
            input[index++] = b.val;
            b = b.next;
        }


        for(int i = 0; i < num; i++){
            int idx = input[i] % m;
            if(ans[idx] == null){
                ans[idx] = new ListNode(input[i]);
            }else{
                ListNode node = ans[idx];

                while(node != null){
                    node = node.next;
                }
                node = new ListNode(input[i]);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode a = node;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = new ListNode(11);
        node = node.next;
        node.next = new ListNode(6);


        ListNode[] ans = solve(5,a);

    }
}
