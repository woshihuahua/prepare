import java.util.Map;

public class dp {
    public static void main(String[] args) {
        //fibo fb = new fibo();
        //System.out.println(fb.ans(5));
        dp1 dp = new dp1();
        String c = "abcbaedds";
        System.out.println(dp.ans(c));

    }
}
class fibo{

    public static int ans(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int prev = 0;
        int cur = 1;
        for(int i = 2;i<= n; i++){
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        return cur;
    }

}
class dp1{
    static int ans(String input){
        char[] in = input.toCharArray();
        int[][] dp = new int[in.length][in.length];
        for(int i = 0; i < in.length ; i++){
            dp[i][i] = 1;
        }
        for(int i = in.length - 2;i>=0;i--){
            for(int j = i+1;j<in.length;j++){
        if(in[i] == in[j]){
            dp[i][j] = dp[i+1][j-1] + 2;
        }else{
            dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
        }
            }
        }
        return dp[0][in.length-1];
    }
}