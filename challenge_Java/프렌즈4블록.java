import java.util.*;

class Solution {
    boolean checkEqual(int row, int col, char[][] map, char[][] tmp) {
        if (map[row][col] == '*')
            return false;
        
        int cnt = 1;
        int underRow = 0;
        for (int i = map.length - 1; i > row; i--)
            if (map[i][col] != '*') {
                underRow = i;
                cnt++;
            }
        
        if (cnt == 1 
            || map[row][col] != map[underRow][col])
            return false;
        
        int rightRow = 0, diagonalRow = 0;
        for (int i = map.length - 1; i >= 0 && cnt != 0; i--)
            if (map[i][col + 1] != '*') {
                diagonalRow = rightRow;
                rightRow = i;
                cnt--;
            }
        
        if (cnt != 0
            || map[row][col] != map[rightRow][col + 1]
            || map[row][col] != map[diagonalRow][col + 1])
            return false;
        
        tmp[row][col] = '*';
        tmp[underRow][col] = '*';
        tmp[rightRow][col + 1] = '*';
        tmp[diagonalRow][col + 1] = '*';
        return true;
    }
    
    public int solution(int h, int w, String[] board) {
        char[][] map = new char[h][w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                map[i][j] = board[i].charAt(j);
        
        while (true) {
            boolean found = false;
            char[][] tmp = new char[h][];
            
            for (int i = 0; i < h; i++)
                tmp[i] = map[i].clone();
            
            for (int i = 0; i < h - 1; i++)
                for (int j = 0; j < w - 1; j++)
                    if (checkEqual(i, j, map, tmp) == true)
                        found = true;
            
            if (found == false)
                break;
            map = tmp;
        }
        
        int answer = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                answer += map[i][j] == '*' ? 1 : 0;
        
        return answer;
    }
}
