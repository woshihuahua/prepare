public class maze {
    static int row,col;
    static boolean flag = false;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean exist(char[][] board, String word){
        StringBuffer sb = new StringBuffer();
        row = board.length;
        col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board, word, i, j, visit, 0, sb);
                }
            }
        }

        return flag;
    }
    public static void dfs(char[][] board, String word, int x, int y, boolean[][] visit, int num, StringBuffer sb){

        if(flag || x < 0 || y < 0 || x == row || y == col || visit[x][y]){
            return;
        }
        if(sb.toString().equals(word)){
            flag = true;
            return;
        }
        if(board[x][y] != word.charAt(num)){
            return;
        }
        visit[x][y] = true;
        sb.append(board[x][y]);
        for(int i = 0; i < 4; i++){
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            dfs(board, word, x, y, visit,num+1,sb);
        }
        sb.deleteCharAt(sb.length()-1);
        visit[x][y] = false;
        return;
    }

    public static void main(String[] args) {
        char[][] input = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        String str = "ABCCED";
        System.out.println(exist(input, str));

    }
}
