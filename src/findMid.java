public class findMid {
    public static void main(String[] args) {
        int[] input = {2,3,4};
        int left = 0;
        int right = input.length;
        int target = input[(left + right) / 2];

        int i = 0;
        int j = (left + right) / 2;
        while(i < j){
            int mid = (i + j) / 2;
            if(input[mid] >= target){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        if(input[i + (left + right) / 2] == target){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
