class Solution {
    public int solution(String dirs) {
        int[][][] record = new int[11][11][4];
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        
        int curX = 5, curY = 5;
        int answer = 0;
        
        for (char c : dirs.toCharArray()) {
            int idx = getIdx(c);
            int opposite = getOpposite(idx);
            int nextX = curX + dirX[idx];
            int nextY = curY + dirY[idx];
            
            if (isValidPos(nextX, nextY) == true) {
                if (record[curX][curY][idx] == 0) {
                    answer++;
                    record[curX][curY][idx]++;
                    record[nextX][nextY][opposite]++;
                }
                curX = nextX;
                curY = nextY;
            }
        }
        return answer;
    }
    
    public int getIdx(char c) {
        if (c == 'U') return 0;
        if (c == 'D') return 1;
        if (c == 'R') return 2;
        return 3;
    }
    
    public int getOpposite(int i) {
        if (i == 0) return 1;
        if (i == 1) return 0;
        if (i == 2) return 3;
        return 2;
    }
    
    public boolean isValidPos(int x, int y) {
        return 0 <= x && x <= 10 && 0 <= y && y <= 10;
    }
}