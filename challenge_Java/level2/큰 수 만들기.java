import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char num : number.toCharArray()) {
            while (stack.empty() == false && stack.peek() < num && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        while (k-- > 0)
            stack.pop();
        
        StringBuilder answer = new StringBuilder();
        for (Character c : stack)
            answer.append(c);
        
        return answer.toString();
    }
}
