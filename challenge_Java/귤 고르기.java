import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] group = new int[10000001];
        for (int i : tangerine)
            group[i]++;
        Arrays.sort(group);
        
        int weight = 0, answer = 0;
        for (int i = group.length - 1; group[i] != 0; i--) {
            weight += group[i];
            answer++;
            if (weight >= k)
                break;
        }
        return answer;
    }
}