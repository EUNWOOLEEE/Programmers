class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int len = prices.length;
        
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            
            while (j < len && prices[i] <= prices[j])
                j++;
            
            answer[i] = j == len ? j - i - 1 : j - i;
        }
        return answer;
    }
}