import java.util.HashMap;

class Solution {
    public int answer = 0, SIZE = 8;
    public char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public HashMap<Character, HashMap<Character, int[]>> map = new HashMap<>();

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[SIZE];
        dfs(data, visited, new char[SIZE], 0);
        return answer;
    }
    
    public void dfs(String[] data, boolean[] visited, char[] line, int idx) {
        if (idx == SIZE) {
            if (isValidLine(data, line) == true)
                answer++;
            return;
        }
        
        for (int i = 0; i < SIZE; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                line[idx] = friends[i];
                dfs(data, visited, line, idx + 1);
                visited[i] = false;
                line[idx] = 0;
            }
        }
    }
    
    public boolean isValidLine(String[] data, char[] line) {
        HashMap<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < SIZE; i++)
            pos.put(line[i], i);

        for (String cond : data) {
            char a = cond.charAt(0);
            char b = cond.charAt(2);
            char operator = cond.charAt(3);
            int distance = cond.charAt(4) - '0';

            int gap = Math.abs(pos.get(a) - pos.get(b)) - 1;

            if (operator == '=' && gap != distance) return false;
            if (operator == '<' && gap >= distance) return false;
            if (operator == '>' && gap <= distance) return false;
        }

        return true;
    }
}
