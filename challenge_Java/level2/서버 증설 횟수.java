import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> server = new LinkedList<>();
        
        int time = 0, answer = 0;
        for (int player : players) {
            while (server.size() > 0 && time - server.peek() == k)
                server.poll();
            if (player == 0) {
                time++;
                continue;
            }
            while ((server.size() + 1) * m <= player) {
                server.add(time);
                answer++;
            }
            time++;
        }
        return answer;
    }
}
