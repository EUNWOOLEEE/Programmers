class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len][4];
        
        dp[0] = land[0];
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k == j)
                        continue;
                    int next = land[i][j] + dp[i - 1][k];
                    dp[i][j] = dp[i][j] > next ? dp[i][j] : next;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++)
            answer = answer > dp[len - 1][i] ? answer : dp[len - 1][i];
        return answer;
    }
}