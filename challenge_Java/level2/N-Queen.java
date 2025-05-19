class Solution {
    public int answer = 0;
    
    public int solution(int n) {
        int[] board = new int[n];
        for (int i = 0; i < n; i++)
            board[i] = -1;
        
        dfs(n, 0, board);
        return answer;
    }
    
    public void dfs(int n, int row, int[] board) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPos(row, col, board) == true) {
                board[row] = col;
                dfs(n, row + 1, board);
                board[row] = -1;
            }
        }
    }
    
    public boolean isValidPos(int row, int col, int[] board) {
        for (int i = 0; i < row; i++)
            if (board[i] == col || Math.abs(row - i) == Math.abs(board[i] - col))
                return false;
        return true;
    }
}
