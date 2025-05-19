import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<Character, Integer> order = new HashMap<>();

        for (int i = 0; i < skill.length(); i++)
            order.put(skill.charAt(i), i);
        
        int answer = 0;
        int idx, prev, expectedOrder;
        
        for (String str : skill_trees) {
            idx = prev = expectedOrder = 0;
            
            for (; idx < str.length(); idx++) {
                char c = str.charAt(idx);
                if (order.containsKey(c) == true) {
                    if (prev > order.get(c) || expectedOrder != order.get(c))
                        break;
                    prev = order.get(c);
                    expectedOrder++;
                }
            }
            
            if (idx == str.length())
                answer++;
        }
        
        return answer;
    }
}