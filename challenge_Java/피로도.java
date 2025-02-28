class Solution {
    private int[][] dungeons;
    private int len;
    private int answer = 0;
    
    public int solution(int k, int[][] src) {
        dungeons = src;
        len = src.length;
        dfs(k, 0, new int[src.length]);
        return answer;
    }
    
    private void dfs(int k, int cnt, int[] visited) {
        answer = Math.max(cnt, answer);
        for (int i = 0; i < len; i++) {
            if (visited[i] == 0 && k >= dungeons[i][0]) {
                int[] tmp = visited.clone();
                tmp[i]++;
                dfs(k - dungeons[i][1], cnt + 1, tmp);
            }
        }
    }
}