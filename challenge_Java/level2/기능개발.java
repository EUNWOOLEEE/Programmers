import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<>();
        int idx = 0, done = 0, days = 1;
        
        while (idx < progresses.length) {
            if (progresses[idx] + speeds[idx] * days >= 100) {
                done++;
                idx++;
                continue;
            }
            if (done > 0) {
                res.add(done);
                done = 0;
            }
            days++;
        }
        res.add(done);
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}