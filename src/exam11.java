import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class exam11 {
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] rob = new int[n][3];
        int i = 0;
        while(sc.hasNextLine()){
            String[] chars = sc.nextLine().split(" ");
            rob[i][0] = Integer.parseInt(chars[0]);
            rob[i][1] = chars[1].equals("L")? 1 : 2;
            rob[i][2] = i;
            i++;
        }
//        int n = 10;
//        int[][] rob = {{94,2,0},{74,1,1},{90,1,2},{75,2,3},{37,2,4},{99,2,5},{62,2,6},{4,1,7},{92,1,8},{44,2,9}};
        int[] res = new int[n];
        Arrays.sort(rob,(o1, o2)->o1[0] - o2[0]);
        LinkedList<int[]> stk = new LinkedList<>();
        for(int j = 0; j < n; j++){
            if(stk.isEmpty() || stk.peek()[1] == rob[j][1] || (stk.peek()[1] == 1 && rob[j][1] == 2)){
                stk.push(rob[j]);
            }else if((stk.peek()[0] - rob[j][0]) % 2 == 0){
                res[stk.peek()[2]] = (rob[j][0] - stk.peek()[0])/2;
                res[rob[j][2]] = (rob[j][0] - stk.peek()[0])/2;
                stk.pop();
            }else{
                int[] tmp = stk.pop();
                stk.push(rob[j]);
                stk.push(tmp);
            }
        }
        while(!stk.isEmpty()){
            int[] tmp = stk.pop();
            if(stk.isEmpty()){
                res[tmp[2]] = -1;
            }else if(stk.peek()[1] == tmp[1] || (stk.peek()[1] == 1 && tmp[1] == 2)){
                res[tmp[2]] = -1;
            }else if((stk.peek()[0] - tmp[0]) % 2 != 0){
                stk.pop();
                stk.push(tmp);
            }else{
                res[stk.peek()[2]] = Math.abs((tmp[0] - stk.peek()[0])/2);
                res[tmp[2]] = Math.abs((tmp[0] - stk.peek()[0])/2);
                stk.pop();
            }
        }
        for(int num: res){
            System.out.println(num);
        }
    }
}
