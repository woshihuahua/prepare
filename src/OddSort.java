public class OddSort {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6};
        int len = input.length;
        int i = 0;
        int j = 1;
        while(i < len && j < len){
            while(i < len && input[i] % 2 == 0){
                i += 2;
            }
            while(j < len && input[j] % 2 == 1){
                j+=2;
            }

            if(i < len && j < len){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;

            }
        }
        for(int n : input){
            System.out.println(n);
        }


    }

}
