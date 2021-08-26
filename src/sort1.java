public class sort1 {
    public static void main(String[] args) {
        int[] input = new int[]{9,8,7,6,5,4,3};
        Fsort fs = new Fsort();
        Fsort.fs(input,0,input.length-1);
        for(int i: input) {
            System.out.println(i);
        }
    }
}
class Fsort{
    public static void fs(int[] arr, int low, int high){
        if(low >= high) return;
        int j = partition(arr, low, high);
        fs(arr, low, j-1);
        fs(arr, j +1, high);

    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high + 1;
        while(true) {
            while(arr[++i] < pivot) {if (i == high) break;}
            while(arr[--j] > pivot) {if (j == low) break;}
            if(i >= j) break;
            swap(arr,i,j);
        }
        swap(arr, low, j);
        return j;

    }
    public static void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
