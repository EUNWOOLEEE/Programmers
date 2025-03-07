import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for (int i : scoville)
            pq.add(i);
        
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            
            if (first >= K && second >= K)
                return answer;
            
            pq.add(first + second * 2);
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}