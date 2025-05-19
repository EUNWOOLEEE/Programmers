import java.util.*;

class Solution {
    int[][] visited;
    
    class coor {
        public int x, y, move;
        
        coor(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        bfs(maps);
        int answer = visited[maps.length - 1][maps[0].length - 1];
        return answer == 0 ? -1 : answer;
    }
    
    public void bfs(int[][] maps) {
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        
        Queue<coor> queue = new LinkedList<>();
        queue.add(new coor(0, 0, 1));
        visited[0][0] = 1;
        
        while (queue.size() > 0) {
            coor cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];
                
                if (isValidPos(maps, nextX, nextY)) {
                    queue.add(new coor(nextX, nextY, cur.move + 1));
                    visited[nextX][nextY] = cur.move + 1;
                }
            }
        }
    }
    
    public Boolean isValidPos(int[][] maps, int x, int y) {
        return (0 <= x && x < maps.length 
                && 0 <= y && y < maps[0].length 
                && maps[x][y] == 1 
                && visited[x][y] == 0);
    }
}