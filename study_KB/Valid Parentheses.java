import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else
                if (stack.empty() == true || isCorrectPair(stack.pop(), c) == false)
                    return false;
        }
        return stack.empty();
    }

    public boolean isCorrectPair(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') 
                || (c1 == '[' && c2 == ']')
                || (c1 == '{' && c2 == '}'));
    }
}
