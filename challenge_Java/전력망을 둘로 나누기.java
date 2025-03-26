class Solution {
    public int answer = 100;
    public boolean[][] map = new boolean[101][101];
    
    public int solution(int n, int[][] wires) {
        for (int[] wire : wires) {
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }
        
        for (int[] wire : wires) {
            int abs = Math.abs(dfs(wire[0], wire[1], wire[0], new boolean[101]) 
                               - dfs(wire[1], wire[0], wire[1], new boolean[101]));
            answer = answer < abs ? answer : abs;
        }
        return answer;
    }
    
    public int dfs(int v1, int v2, int cur, boolean[] visited) {
        int result = 1;
        
        if (visited[cur] == false && cur != v2) {
            visited[cur] = true;
            
            for (int i = 1; i <= 100; i++)
                if (i != v2 && map[cur][i] == true && visited[i] == false)
                    result += dfs(v1, v2, i, visited);
        }
        return result;
    }
}
