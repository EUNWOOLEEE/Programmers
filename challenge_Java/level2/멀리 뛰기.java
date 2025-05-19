class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        
        int[] jump = new int[n];
        jump[0] = 1;
        jump[1] = 2;
        for (int i = 2; i < n; i++)
            jump[i] = (jump[i - 1] + jump[i - 2]) % 1234567;
        
        return jump[n - 1];
    }
}
