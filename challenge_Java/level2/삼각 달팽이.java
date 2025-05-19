class Solution {
    public int[][] map;
    public int num = 1, cnt, row = 0, col = 0;
    
    public int[] solution(int n) {
        cnt = n;
        map = new int[n][n];
        
        int len = (n + 1) * (n / 2);
        len += n % 2 == 0 ? 0 : n / 2 + 1;
        
        while (num <= len) {
            increaseRow();
            increaseCol();
            decreaseRowCol();
        }
        
        int idx = 0;
        int[] answer = new int[len];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0)
                    break;
                answer[idx++] = map[i][j];
            }
        }
        return answer;
    }
    
    public void increaseRow() {
        for (int i = 0; i < cnt; i++) {
            map[row++][col] = num++;
        }
        row--;
        col++;
        cnt--;
    }
    
    public void increaseCol() {
        for (int i = 0; i < cnt; i++) {
            map[row][col++] = num++;
        }
        col -= 2;
        row--;
        cnt--;
    }
    
    public void decreaseRowCol() {
        for (int i = 0; i < cnt; i++) {
            map[row--][col--] = num++;
        }
        row += 2;
        col++;
        cnt--;
    }
}
