class Solution {
    public void solve(char[][] board) {
        int rows = board.length-1;
        int cols = board[0].length-1;

        for (int j=0;j<=cols;++j) {
            if (board[0][j]=='O')
                dfs(board,0,j, rows, cols);
            if (board[rows][j]=='O') {
                dfs(board,rows,j, rows, cols);
            }
        }

        for (int i=0;i<=rows;++i) {
            if (board[i][0]=='O')
                dfs(board,i,0, rows, cols);
            if (board[i][cols]=='O') {
                dfs(board,i,cols, rows, cols);
            }
        }
        
        for(int i=0;i<=rows;++i) {
            for (int j=0;j<=cols;++j) {
                if (board[i][j]=='O') board[i][j]='X';
                if (board[i][j]=='S') board[i][j]='O';
            }
        }

    }

    private void dfs(char[][] board, int i, int j, int rows, int cols) {
        if (i<0 || i>rows || j<0 ||j>cols || board[i][j]=='S' || board[i][j]=='X') return;

        board[i][j]='S';

        dfs(board, i-1,j,rows, cols);
        dfs(board, i+1,j,rows, cols);
        dfs(board, i,j-1,rows, cols);
        dfs(board, i,j+1,rows, cols);
    }
}
