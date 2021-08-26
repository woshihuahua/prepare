public class Sort11 {

    public static void main(String[] args) {
        int[] input1 = {1,3,4,5,3,4,3,4,2,6};
        int[] input22 = {1,2,5,6,4,3,3,9,10};
        int[] small = new int[input22.length];
        int min = input22[input22.length-1];
        int max = input22[0];
        for(int i = input22.length - 1; i >= 0; i--){
            if(input22[i] < min){
                min = input22[i];
            }
            small[i] = min;
        }
        for(int i = 0; i < input22.length - 1; i++){
            if(input22[i] > max) {
                max = input22[i];

                if (input22[i] < small[i + 1]) {
                    System.out.println(input22[i]);
                }
            }
        }

    }
}
