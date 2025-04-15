import java.util.ArrayList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Double> arr = new ArrayList<>();
        arr.add((double)k);
        
        double cur = k, prev = k;
        while (cur > 1) {
            prev = cur;
            cur = cur % 2 == 0 ? cur / 2 : cur * 3 + 1;
            arr.add(((cur + prev) * 1 / 2) + arr.get(arr.size() - 1));
        }
        
        double[] answer = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = arr.size() + ranges[i][1] - 1;
            answer[i] = start > end ? -1 : arr.get(end) - arr.get(start);
        }
        return answer;
    }
}
