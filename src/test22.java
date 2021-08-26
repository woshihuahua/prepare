public class test22 {

    public static String solution2(String input){
        char[] in = input.toCharArray();
        if(in.length == 0) return new String();
        StringBuffer sb = new StringBuffer();
        int cnt = 1;
        char leader = in[0];
        sb.append(leader);
        for(int i = 1; i <= in.length - 1; i++) {
            while(in[i] == leader) {
                cnt++;
                i++;
            }
            if(cnt > 1) {
                i--;
                sb.append(cnt);
                cnt = 1;
            }else {
                leader = in[i];
                sb.append(leader);
            }

        }
        return sb.toString();

    }

    public static void main1(String[] args) {

        String input = "aabccddde";
        System.out.println(solution2(input));
    }

    public static void main2(String[] args) {
        int[] input = {2,2,3,4,5,1};
        int cnt = 0;
        for(int num: input) {
            int a = num / 2;
            if( num % 2  == 1) {
                a = a + 1;
            }
            cnt += a;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4));

    }

    public static  double sqrt(double n) {
        double l = 1;
        double r = n;
        while(r-l >= 0.01){
            double m = (l+r)/2;
            if(m*m <n) {
                l = m;
            }else{
                r=m;
            }
        }
return r;
    }
}
