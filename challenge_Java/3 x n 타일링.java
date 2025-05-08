class Solution {
    public int solution(int n) {
        if (n % 2 == 1)
            return 0;
        
        int MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int i = 2; i <= n; i += 2) {
            dp[i] = (dp[i] + (dp[i - 2] * 3)) % MOD;
            
            for (int j = 0; j < i - 2; j += 2)
                dp[i] = (dp[i] + (dp[j] * 2)) % MOD;
        }
            
        return (int)dp[n];
    }
}
