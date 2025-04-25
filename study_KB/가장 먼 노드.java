import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] arr : edge) {
            graph[arr[0]][arr[1]] = true;
            graph[arr[1]][arr[0]] = true;
        }
        
        int[] visited = new int[n + 1];
        bfs(n, graph, visited);
        
        int answer = 0, max = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i] > max) {
                max = visited[i];
                answer = 1;
            }
            else if (visited[i] == max)
                answer++;
        }
            
        return answer;
    }
    
    public void bfs(int n, boolean[][] graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (queue.size() > 0) {
            int cur = queue.poll();
            
            for (int i = 1; i <= n; i++) {
                if (graph[cur][i] == true && visited[i] == 0) {
                    visited[i] = visited[cur] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
