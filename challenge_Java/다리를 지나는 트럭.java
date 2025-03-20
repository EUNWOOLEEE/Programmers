class Solution {
    public int solution(int bridge_length, int weight, int[] trucks) {
        int[] time = new int[trucks.length];
        int answer = 0, cur_weight = 0;
        
        for (int front = 0, rear = 0; front < trucks.length; answer++) {
            if (answer - time[front] == bridge_length)
                cur_weight -= trucks[front++];
            
            if (rear < trucks.length && rear - front < bridge_length && cur_weight + trucks[rear] <= weight) {
                cur_weight += trucks[rear];
                time[rear++] = answer;
            }
        }
        
        return answer;
    }
}
