import java.util.*;

class Solution {
    public long solution(int[] weights) {
        HashMap<Double, Integer> map = new HashMap<>();
        long answer = 0;
        Arrays.sort(weights);
        
        for (int num : weights) {
            double a = num * 1.0;
            double b = num * 2.0 / 3.0;
            double c = num * 1.0 / 2.0;
            double d = num * 3.0 / 4.0;
            
            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);
            
            map.put(num * 1.0, map.getOrDefault(num * 1.0, 0) + 1);
        }
        return answer;
    }
}
