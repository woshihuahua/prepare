public class Trip {
    public static void main(String[] args) {
//        int len = 10;
//        int n = 2;
//        int[][] dp = new int[n+1][len];
//        dp[0][0] = 1;
//        for(int i = 1; i <= n; i++){
//            for(int j = 0; j < len; j++){
//                dp[i][j] = dp[i-1][(j + 1) % len] + dp[i-1][(j - 1 + len) % len];
//            }
//        }
//        System.out.println(dp[n][0]);
        String st =  "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String[] haha = st.split(",");
        for(String s : haha){
            System.out.println(s);
        }
    }
}
