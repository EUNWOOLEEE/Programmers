class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        dp[x] = 1;
        
        for (int i = x; i <= y - n; i++) {
            if (dp[i] == 0)
                continue;
            
            for (int j = 0; j < 3; j++) {
                int next = getNext(i, n, j);
                
                if (next <= y)
                    if (dp[next] == 0 || dp[i] + 1 < dp[next])
                        dp[next] = dp[i] + 1;
            }
        }
        return dp[y] - 1;
    }
    
    public int getNext(int i, int n, int order) {
        if (order == 0)
            return i + n;
        else if (order == 1)
            return i * 2;
        return i * 3;
    }
}