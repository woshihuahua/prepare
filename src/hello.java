import java.util.Scanner;

public class hello {
    public static String leader;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String str = sc.nextLine();
        int length = Integer.parseInt(s[0]);
        int len = Integer.parseInt(s[1]);
        visit = new boolean[length];
        dfs(length, len, str, 0);
        System.out.println(leader);
    }
    public static void dfs(int length, int len, String str, int begin){
        if(sb.length() == len){

            if(leader == null) {
                leader = sb.toString();
            }else if(big(sb.toString(),leader)){
                leader = sb.toString();
            }
            return;
        }
        for(int i = begin; i < length; i++){
            if(!visit[i]) {
                visit[i] = true;
                sb.append(str.charAt(i));
                dfs(length, len, str, begin + 1);
                sb.deleteCharAt(sb.length() - 1);
                visit[i] = false;
            }
        }
    }

    public static boolean big(String a, String b){
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        for(int i = 0; i < aa.length; i++){
            if(aa[i] < bb[i]){
                return false;
            }
        }
        return true;
    }
}
