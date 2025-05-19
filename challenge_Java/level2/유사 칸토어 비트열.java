class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        l--;

        while (l < r) {
            for (long i = l; (i - 2) % 5 != 0; i /= 5) {
                if (i < 5 && i != 2) {
                    answer++;
                    break;
                }
            }
            l++;
        }

        return answer;
    }
}
