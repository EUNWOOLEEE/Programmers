import java.util.*;

class Solution {
    public int[] answer = new int[4];
    public int[] in = new int[1000001];
    public boolean eight, bar;
    public boolean[] visited;
    public HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(int[][] edges) {
        int maxNode = 0;
        
        for (int[] edge : edges) { 
            in[edge[1]]++;
            maxNode = Math.max(maxNode, edge[0]);
            maxNode = Math.max(maxNode, edge[1]);
            
            if (map.containsKey(edge[0]) == false)
                map.put(edge[0], new ArrayList<>());
            
            map.get(edge[0]).add(edge[1]);
        }
        
        for (int i = 1; i <= maxNode; i++) {
            if (in[i] == 0 && map.containsKey(i) == true && map.get(i).size() > 1) {
                answer[0] = i;
                break;
            }
        }
        
        visited = new boolean[maxNode + 1];
        for (int node : map.get(answer[0])) {
            eight = bar = false;
            dfs(node);
            
            if (bar == true) // 막대
                answer[2]++;
            else if (eight == true) // 8자
                answer[3]++;
            else
                answer[1]++;
        }
        return answer;
    }
    
    public void dfs(int curNode) {
        if (map.containsKey(curNode) == false) {
            bar = true;
            return ;
        }
        if (map.get(curNode).size() == 2) {
            eight = true;
            return ;
        }
        
        for (int node : map.get(curNode))
            if (visited[node] == false) {
                visited[node] = true;                
                dfs(node);
            }
    }
}
