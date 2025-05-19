class Solution {
    public int[] solution(int[] sequence, int k) {
        int front = 0, rear = -1, sum = 0;
        int len = sequence.length;
        int[] answer = new int[]{0, len};
        
        while (++rear < len) {
            sum += sequence[rear];
            
            while (sum > k && front < len)
                sum -= sequence[front++];
            
            if (sum == k && answer[1] - answer[0] > rear - front) {
                answer[0] = front;
                answer[1] = rear;
            }
        }
        return answer;
    }
}