class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        long diff = Long.MAX_VALUE;
        int max = 0, min = 0, level = 0;
        
        for (int n : diffs)
            max = max > n ? max : n;
        
        while (min <= max) {
            long sum = times[0];
            level = ((max - min) / 2) + min;
            
            for (int i = 1; i < diffs.length; i++) {
                int repeat = diffs[i] - level < 0 ? 0 : diffs[i] - level;
                sum += repeat * (times[i] + times[i - 1]) + times[i];
            }
            
            if (sum > limit)
                min = level + 1;
            else {
                max = level - 1;
                answer = answer < level ? answer : level;
            }
        }
        
        return answer == 0 ? 1 : answer;
    }
}
