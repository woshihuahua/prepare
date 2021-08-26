import java.util.Stack;

public class kuohao {
    public static Stack<Integer> stk1 = new Stack<>();
    public static Stack<Integer> stk2 = new Stack<>();
    public static void main(String[] args) {
 //这样答案是 13才对
// 还是有bug 不是取模的问题
        String s = "((()())(())()())";
        char[] ch = s.toCharArray();
        stk2.push(1);
        int ans = dfs(ch);
        System.out.println(ans);
    }
    public static int dfs(char[] ch){
        int temp = 1;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '('){
                stk1.push(i);
            }else{
                if(stk1.peek() == i - 1){
                    stk1.pop();
                    if(stk1.isEmpty()){
                        int a = stk2.pop();
                        a *= 2;
                        stk2.push(a);
                    }else{
                        temp *= 2;
                    }

                }else{
                    stk1.pop();
                    temp += 1;
                    if(stk1.isEmpty()){
                    int b = stk2.pop();
                    b *= temp;
                    temp = 1;
                    stk2.push(b);}
                }
            }
        }
        return stk2.pop();
    }
}
