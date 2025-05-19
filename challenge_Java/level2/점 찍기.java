class Solution {
    public long solution(int k, long d) {
        long answer = 0;
        for (long x = 0; x <= d; x += k) {
            long y = (long)Math.sqrt(d * d - x * x);
            answer += (y / k) + 1;
        }
        return answer;
    }
}
