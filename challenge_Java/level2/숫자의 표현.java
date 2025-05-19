class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int total = i;
            for (int j = i + 1; j <= n && total < n; j++)
                total += j;
            answer = total == n ? answer + 1 : answer;
        }
        return answer;
    }
}
