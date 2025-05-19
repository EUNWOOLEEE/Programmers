class Solution {
    public int solution(int n, int a, int b) {
        int power = Integer.bitCount(n - 1);
        a--;
        b--;
        n /= 2;
        
        while (a / n == b / n) {
            n /= 2;
            power--;
        }

        return power;
    }
}