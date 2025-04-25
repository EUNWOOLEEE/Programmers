class Solution {
    public boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                rec(n, i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void rec(int n, int curV, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (computers[curV][i] == 1 && visited[i] == false) {
                visited[i] = true;
                rec(n, i, computers);
            }
        }
    }
}
