//stack 미사용
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

//stack 사용
import java.util.Stack;

class Solution {
    class Stock {
        int idx;
        int value;
        
        public Stock(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Stock> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (stack.empty() == false && stack.peek().value > prices[i]) {
                int idx = stack.pop().idx;
                answer[idx] = i - idx;
            }
            stack.push(new Stock(i, prices[i]));
        }
        
        while (stack.empty() == false) {
            int idx = stack.pop().idx;
            answer[idx] = len - idx - 1;
        }
        
        return answer;
    }
}
