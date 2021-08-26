public class exam {
    public static void main(String[] args) {
        int n = 8;
//        int i = 0;
//        int j = n;
//        while(j >= i){
//            int mid = (j + i) / 2;
//            if(mid == n / mid){
//                System.out.println(mid);
//            }else if(mid > n / mid){
//                j = mid - 1;
//            }else{
//                i = mid + 1;
//            }
//        }
//        System.out.println(j);

        double i = 1;
        double j = n;
        while(j - i >= 0.001){
            double mid = (i  + j) / 2;
            if(mid >= n / mid){
                j = mid;
            }else{
                i = mid;
            }
        }
        System.out.println(j);
    }
}
