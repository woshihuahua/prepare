import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] input = new int[]{10,9,8,7,1,2,3,4,5};
       //Arrays.sort(input);
        //spt x = new spt();
        //System.out.println(x.find(input, 0));
//fastSort fs = new fastSort();
//fs.FSort(input,0,input.length-1);
//for(int i:input){
//    System.out.println(i);
//}
//        topK ss = new topK();
//        ss.KSort(input,0,input.length-1,3);
//        for(int i = 0;i<3;i++){
//            System.out.println(input[i]);
//        }
heapp hp = new heapp();
hp.heapSort(input, input.length);
        for(int i : input){
            System.out.println(i);
        }
    }
}
class spt{
    static boolean find(int[] input, int num){
        int low = 0;
        int high = input.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(input[mid] == num){
                return  true;
            }else if(input[mid] < num){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}
class fastSort{
    static void swap(int[] input, int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    static void FSort(int[] input, int low,int high){
        if(low >= high) return;
        int j = partition(input,low,high);
        FSort(input,low,j-1);
        FSort(input,j+1,high);
    }
    static int partition(int[] input, int low,int high){
        int i = low;
        int j = high+1;
        while (true) {
            while(input[++i] < input[low]){if(i==high) break;}
            while(input[--j] > input[low]){if(j == low) break;}
            if(i>=j){break;}
            swap(input,i,j);
        }
        swap(input,low,j);
        return j;
    }
}
class topK{
    static void swap(int[] input, int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    static void KSort(int[] input, int low,int high,int K){
        if(low >= high) return;
        int j = partition(input,low,high);
        if(j == K){return;}
        if(j < K){KSort(input, j+1, high, K);}
        else{
            KSort(input,low,j-1,K);
        }
    }
    static int partition(int[] input, int low,int high){
        int i = low;
        int j = high+1;
        while (true) {
            while(input[++i] < input[low]){if(i==high) break;}
            while(input[--j] > input[low]){if(j == low) break;}
            if(i>=j){break;}
            swap(input,i,j);
        }
        swap(input,low,j);
        return j;
    }

}
class heapp{
    static void swap(int[] input, int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    static void heapSort(int[] input, int length){
        heapBuild(input,length);
        for(int i = input.length -1;i>=0;i--){
            swap(input,0,i);
            heapBuild(input,i);
        }

    }
    static void heapBuild(int[] input,int length){
        int parent = (length -1 )/2;
        for(int i = parent;i>=0;i--){
            heapify(input,length,i);
        }
    }
    static void heapify(int[] input,int length,int i){
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 < length && input [max] < input [c1]){
            max = c1;
        }
        if(c2 < length && input [max] < input [c2]){
           max = c2;
        }
        if(max != i){
            swap(input,max,i);
        }
    }
}