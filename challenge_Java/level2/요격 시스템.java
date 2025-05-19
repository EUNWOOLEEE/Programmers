import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (int[] a, int[] b) -> {
            return a[1] - b[1];
        });
        
        int answer = 0;
        for (int idx = 0; idx < targets.length; idx++) {
            int curE = targets[idx][1];
            answer++;
            while (idx + 1 < targets.length && curE > targets[idx + 1][0])
                idx++;
        }
        return answer;
    }
}
