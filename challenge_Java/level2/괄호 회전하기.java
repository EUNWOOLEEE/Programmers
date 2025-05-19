import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for (int start = 0, next = 0; start < len; start++) {
            Stack<Character> stack = new Stack<>();
            
            for (next = start; next < start + len; next++) {
                char c = s.charAt(next % len);
                
                if (c == '(' || c == '{' || c == '[')
                    stack.push(c);
                else
                    if (stack.isEmpty() == true || isPair(stack.pop(), c) == false)
                        break;
            }
            
            if (stack.isEmpty() == true && next == start + len)
                answer++;
        }
        return answer;
    }
    
    private Boolean isPair(char a, char b) {
        if ((a == '(' && b == ')') 
            || (a == '{' && b == '}') 
            || (a == '[' && b == ']')) return true;
        return false;
    }
}