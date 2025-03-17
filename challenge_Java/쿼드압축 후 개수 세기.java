class Solution {
    public int[][] standard = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    public int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        divide(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void divide(int[][] arr, int row, int col, int size) {
        for (int i = 0; i < 4; i++) {
            int nextRow = row + standard[i][0] * size;
            int nextCol = col + standard[i][1] * size;
            
            if (checkNums(arr, nextRow, nextCol, size) == false)
                divide(arr, nextRow, nextCol, size / 2);
            else
                answer[arr[nextRow][nextCol]]++;
            
            if (row == 0 && col == 0 && size == arr.length)
                break;
        }
    }
    
    public boolean checkNums(int[][] arr, int row, int col, int size) {
        int num = arr[row][col];
        
        for (int i = row; i < row + size; i++)
            for (int j = col; j < col + size; j++)
                if (arr[i][j] != num)
                    return false;
        return true;
    }
}
