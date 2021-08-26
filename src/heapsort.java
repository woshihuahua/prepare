import java.awt.*;

public class heapsort {
    public static void main(String[] args) {
        heapsort hs = new heapsort();
        int[] input = {2,34,1,3,45,2,3};
        hs.heapsort(input, input.length);
        for(int i: input) {
            System.out.println(i);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void heapsort(int[] arr, int length){
        heapBuild(arr,length);
        for(int i = length - 1; i >= 0; i--){
            swap(arr, 0, i);
            heapBuild(arr, i);
        }
    }

    public void heapBuild(int[] arr, int length){
        int parent = (length - 1) / 2;
        for( int i = parent; i >= 0; i--) {
            heapify(arr, i ,length);
        }
    }
    public void heapify(int[] arr, int i, int length){
        int parent = i;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        if(c1 < length && arr[c1] < arr[parent]){
            parent = c1;
        }
        if(c2 < length && arr[c2] < arr[parent]){
            parent = c2;
        }
        if(parent != i){
            swap(arr,parent,i);
        }
    }
}
