import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<int[]> list = new ArrayList();
        while(in.hasNextLine()){
            String[] str = in.nextLine().split(",");
            int[] input = new int[str.length];
            for(int i = 0; i < str.length; i++){
                input[i] = Integer.parseInt(str[i]);
            }
            list.add(input);
        }
        int number = list.size();
        int[] pos = new int[number];
        int flag = -1;
        while(true){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < number; i++){
                if(list.get(i)[pos[i]] < min ){
                    flag = i;
                    min = list.get(i)[pos[i]];
                    pos[i] ++;
                    if(pos[i] == list.get(i).length){
                        System.out.println(-1);
                    }

                }
            }

        }

    }
}
