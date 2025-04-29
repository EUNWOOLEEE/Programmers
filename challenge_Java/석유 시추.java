import java.util.*;

class Solution {
    public int width, height;
    public int[][] numbered;
    public int[] count = new int[250000];
    public int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] land) {
        width = land[0].length;
        height = land.length;
        numbered = new int[height][width];
        
        int num = 1;
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                if (isValidPos(land, row, col) == true && numbered[row][col] == 0)
                    bfs(land, row, col, num++);
        
        int answer = 0;
        for (int col = 0; col < width; col++) {
            HashSet<Integer> set = new HashSet<>();

            for (int row = 0; row < height; row++)
                if (numbered[row][col] != 0)
                    set.add(numbered[row][col]);
            
            int res = 0;
            for (int n : set)
                res += count[n];
            
            answer = answer > res ? answer : res;
        }
        return answer;
    }
    
    public void bfs(int[][] land, int row, int col, int num) {
        // [0]: row, [1]: col
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        count[num]++;
        numbered[row][col] = num;

        while (queue.size() > 0) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = cur[0] + dir[i][0];
                int nextCol = cur[1] + dir[i][1];
                
                if (isValidPos(land, nextRow, nextCol) == true) {
                    queue.add(new int[]{nextRow, nextCol});
                    count[num]++;
                    numbered[nextRow][nextCol] = num;
                }
            }
        }
    }
    
    public boolean isValidPos(int[][] land, int row, int col) {
        return (0 <= row && row < height 
                && 0 <= col && col < width 
                && land[row][col] == 1
                && numbered[row][col] == 0);
    }
}
