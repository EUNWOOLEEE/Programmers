class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= 3; i++)
            dp[i] = i;
        for (int i = 4; i <= n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        
        return dp[n];
    }
}