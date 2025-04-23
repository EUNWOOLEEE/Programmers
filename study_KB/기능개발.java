import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<>();
        int idx = 0;
        
        while (idx < progresses.length) {
            int days = (int)Math.ceil((double)(100 - progresses[idx]) / speeds[idx]);
            int cnt = 0;
            
            while (idx < progresses.length && progresses[idx] + (days * speeds[idx]) >= 100) {
                cnt++;
                idx++;
            }
            res.add(cnt);
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
