import java.util.*;

class Solution {
    public int[] answer = new int[2];
    public boolean[][] visited;
    public int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int height, width;
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        height = m;
        width = n;
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (picture[row][col] != 0 && visited[row][col] == false) {
                    answer[0]++;
                    visited[row][col] = true;
                    bfs(picture, new int[]{row, col});
                }
            }
        }
        return answer;
    }
    
    public void bfs(int[][] pic, int[] pos) {
        int sum = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pos);
        
        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();
        
            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dir[i][0], cur[1] + dir[i][1]};
                    
                if (isValidPos(pic, pos, next) == true) {
                    sum++;
                    visited[next[0]][next[1]] = true;
                    queue.add(next);
                }
            }
        }
        answer[1] = answer[1] > sum ? answer[1] : sum;
    }
    
    public boolean isValidPos(int[][] pic, int[] start, int[] pos) {
        return (0 <= pos[0] && pos[0] < height
                && 0 <= pos[1] && pos[1] < width
                && pic[start[0]][start[1]] == pic[pos[0]][pos[1]]
                && visited[pos[0]][pos[1]] == false);
    }
}
