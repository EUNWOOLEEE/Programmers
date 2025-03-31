import java.util.*;

class Solution {
    class Coor {
        public int row, col, cnt;
        
        public Coor(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
    
    public String[] map;
    public int width, height;
    public int[][] direction = {{1, -1, 0, 0}, {0, 0, 1, -1}};
            
    public boolean isValidPos(Coor pos, boolean[][] visited) {
        return (0 <= pos.row && pos.row < height
                && 0 <= pos.col && pos.col < width 
                && visited[pos.row][pos.col] == false
                && map[pos.row].charAt(pos.col) != 'X');
    }
    
    public int bfs(Coor start, Coor goal) {
        boolean[][] visited = new boolean[height][width];
        visited[start.row][start.col] = true;
        Queue<Coor> queue = new LinkedList<>();
        queue.add(start);
        
        while (queue.size() > 0) {
            Coor cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Coor next = new Coor(cur.row + direction[0][i],
                                     cur.col + direction[1][i],
                                     cur.cnt + 1);
                
                if (next.row == goal.row && next.col == goal.col)
                    return next.cnt;
                
                if (isValidPos(next, visited) == true) {
                    queue.add(next);
                    visited[next.row][next.col] = true;
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        Coor start = null, lever = null, exit = null;
        width = maps[0].length();
        height = maps.length;
        map = maps;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i].charAt(j) == 'S')
                    start = new Coor(i, j, 0);
                if (map[i].charAt(j) == 'L')
                    lever = new Coor(i, j, 0);
                if (map[i].charAt(j) == 'E')
                    exit = new Coor(i, j, 0);
            }
        }        
        
        lever.cnt = bfs(start, lever);
        if (lever.cnt == -1)
            return -1;
        return bfs(lever, exit);
    }
}
