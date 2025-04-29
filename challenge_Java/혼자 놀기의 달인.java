// 수정 코드
import java.util.*;

class Solution {
    public int solution(int[] cards) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        boolean[] visited = new boolean[cards.length + 1];
        for (int i = 0; i < cards.length; i++)
            if (visited[i + 1] == false)
                arr.add(dfs(cards, 0, i, visited));
        
        if (arr.size() < 2)
            return 0;
        
        Collections.sort(arr);
        return arr.get(arr.size() - 1) * arr.get(arr.size() - 2);
    }
    
    public int dfs(int[] cards, int cnt, int idx, boolean[] visited) {
        if (visited[cards[idx]] == true)
            return cnt;
        
        visited[cards[idx]] = true;
        return dfs(cards, cnt + 1, cards[idx] - 1, visited);
    }
}

// 기존 코드
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for (int i = 0; i < cards.length; i++) {
            boolean[] visited = new boolean[cards.length + 1];
            int first = dfs(cards, 0, i, visited);
            
            for (int j = i + 1; j < cards.length; j++) {
                int second = dfs(cards, 0, j, visited);
                answer = answer > first * second ? answer : first * second;
            }
        }
        return answer;
    }
    
    public int dfs(int[] cards, int cnt, int idx, boolean[] visited) {
        if (visited[cards[idx]] == true)
            return cnt;
        
        visited[cards[idx]] = true;
        return dfs(cards, cnt + 1, cards[idx] - 1, visited);
    }
}
