import java.util.*;

class Solution {
    HashMap<String, ArrayList<int[]>> shortestRoutes = new HashMap<>();
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] points, int[][] routes) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                
                String key = (i + 1) + " " + (j + 1);
                shortestRoutes.put(key, bfs(points[i], points[j]));
            }
        }
            
        int answer = 0;
        HashMap<String, Integer> visited = new HashMap<>();
        
        for (int[] route : routes) {
            int time = 0;
            for (int i = 0; i < route.length - 1; i++) {
                String key = route[i] + " " + route[i + 1];
                ArrayList<int[]> routeArr = shortestRoutes.get(key);

                int j = i == 0 ? 0 : 1;
                for (; j < routeArr.size(); j++) {
                    int[] pos = routeArr.get(j);
                    key = time + " " + pos[0] + " " + pos[1];

                    answer = visited.containsKey(key) == true && visited.get(key) == 1 ? answer + 1 : answer;
                    visited.put(key, visited.getOrDefault(key, 0) + 1);
                    time++;
                }
            }
        }
        return answer;
    }
    
    public ArrayList<int[]> bfs(int[] start, int[] goal) {
        boolean[][] visited = new boolean[101][101];
        Queue<ArrayList<int[]>> queue = new LinkedList<>();
        ArrayList<int[]> tmp = new ArrayList<>();
        tmp.add(start);
        queue.add(tmp);
        visited[start[0]][start[1]] = true;
        
        while (queue.isEmpty() == false) {
            ArrayList<int[]> cur = queue.poll();
            int[] curPos = cur.get(cur.size() - 1);
            
            for (int i = 0; i < 4; i++) {
                int[] nextPos = {curPos[0] + dir[i][0], curPos[1] + dir[i][1]};
                
                if (nextPos[0] == goal[0] && nextPos[1] == goal[1]) {
                    cur.add(nextPos);
                    return cur;
                }
                
                if (isValidPos(nextPos, visited) == true) {
                    ArrayList<int[]> next = new ArrayList<>(cur);
                    next.add(nextPos);
                    queue.add(next);
                    visited[nextPos[0]][nextPos[1]] = true;
                }
            }
        }
        return null;
    }
    
    public boolean isValidPos(int[] pos, boolean[][] visited) {
        return (0 < pos[0] && pos[0] <= 100
                && 0 < pos[1] && pos[1] <= 100
                && visited[pos[0]][pos[1]] == false);
    }
}
