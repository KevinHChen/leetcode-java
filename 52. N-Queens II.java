class Solution {

    private int cnt;
    
    public int totalNQueens(int n) {
        int[] solution = new int[n];
        cnt=0;
        dfs(n, 0, solution);
        return cnt;
    }

    private boolean satisfy(int[] solution, int row, int col) {
        for(int i=0;i<row;++i) { //check previous rows
            if (solution[i]==col || Math.abs(row - i) == Math.abs(col - solution[i])) { // never Math.abs(use (row-i)/(col-solution[i]))==1 here at the risk of dividing by 0
                return false;
            }
        }
        // System.out.printf("solution found: %s\n", Arrays.toString(solution));
        return true;
    }

    private void dfs(int n, int row, int[] solution) {
        if (row>n-1) { //exceeds the last row
            cnt++;
            return;
        }

        for (int col=0;col<n;++col) {
            if (satisfy(solution, row, col)) {
                solution[row]=col;
                dfs(n, row+1, solution);
            }
        }
    }
}
