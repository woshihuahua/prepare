import java.util.ArrayList;

public class Filter {
    public static void main(String[] args) {
        int[] input = {1,1,2,3,4,5,6,4,4,2,1,1};
        int left = 0;
        int right = input.length - 1;
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(left <= right){
            while(left < input.length - 1 && input[left] == input[left + 1]){left++;}
            while(right > 0 && input[right] == input[right - 1]){right--;}
            if(left > right){
                ans.add(input[left]);
                break;
            }
            if(input[left] < input[right]){
                ans.add(input[left]);
                left++;
            }else if(input[left] > input[right]){
                ans.add(input[right]);
                right--;
            }else{
                ans.add(input[left]);
                left++;
                right--;
            }
        }
        System.out.println(ans);
    }
}
