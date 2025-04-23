import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0, sum = 0;
        for (int n : d) {
            if (sum + n > budget)
                break;
            answer++;
            sum += n;
        }
        return answer;
    }
}
