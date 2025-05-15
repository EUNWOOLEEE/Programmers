// 반복문 리팩토링
import java.util.*;

class Solution {
    public int height, width;
    public int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    public boolean[][][] visited;
    public ArrayList<Integer> res = new ArrayList<>();
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[] solution(String[] grid) {
        height = grid.length;
        width = grid[0].length();
        visited = new boolean[height][width][4];

        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                for (int dir = 0; dir < 4; dir++)
                    if (visited[row][col][dir] == false)
                        res.add(cntCycle(grid, row, col, dir));
        
        return res.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    public int cntCycle(String[] grid, int curRow, int curCol, int curDir) {
        int cnt = 0;
        
        while (visited[curRow][curCol][curDir] == false) {
            visited[curRow][curCol][curDir] = true;
            
            int nextRow = (curRow + dirs[curDir][0] + height) % height;
            int nextCol = (curCol + dirs[curDir][1] + width) % width;
            int nextDir = curDir;

            char dir = grid[nextRow].charAt(nextCol);
            if (dir == 'L')
                nextDir = curDir == UP ? LEFT
                        : curDir == DOWN ? RIGHT
                        : curDir == LEFT ? DOWN
                        : UP;
            else if (dir == 'R')
                nextDir = curDir == UP ? RIGHT
                        : curDir == DOWN ? LEFT
                        : curDir == LEFT ? UP
                        : DOWN;
            
            curRow = nextRow;
            curCol = nextCol;
            curDir = nextDir;
            cnt++;
        }
        return cnt;
    }
}


// 재귀(런타임 에러)
import java.util.*;

class Solution {
    public int height, width;
    public int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    public boolean[][][] visited;
    public ArrayList<Integer> res = new ArrayList<>();
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[] solution(String[] grid) {
        height = grid.length;
        width = grid[0].length();
        visited = new boolean[height][width][4];

        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                for (int dir = 0; dir < 4; dir++)
                    if (visited[row][col][dir] == false)
                        dfs(grid, row, col, dir, 0);
        
        return res.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    public void dfs(String[] grid, int curRow, int curCol, int curDir, int cnt) {
        if (visited[curRow][curCol][curDir] == true) {
            res.add(cnt);
            return;
        }
        visited[curRow][curCol][curDir] = true;
        
        int nextRow = (curRow + dirs[curDir][0] + height) % height;
        int nextCol = (curCol + dirs[curDir][1] + width) % width;
        int nextDir = curDir;

        char dir = grid[nextRow].charAt(nextCol);
        if (dir == 'L')
            nextDir = curDir == UP ? LEFT
                    : curDir == DOWN ? RIGHT
                    : curDir == LEFT ? DOWN
                    : UP;
        else if (dir == 'R')
            nextDir = curDir == UP ? RIGHT
                    : curDir == DOWN ? LEFT
                    : curDir == LEFT ? UP
                    : DOWN;
        
        dfs(grid, nextRow, nextCol, nextDir, cnt + 1);
    }
}
