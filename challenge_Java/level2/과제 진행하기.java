import java.util.*;

class Solution {
    public int compare(String[] a, String[] b) {
        return a[1].compareTo(b[1]);
    }
    
    public String[] solution(String[][] plans) {
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = new String[plans.length];
        int cur = 0, idx = 0;
        
        Arrays.sort(plans, this::compare);
        
        for (String[] plan : plans) {
            String[] parseTime = plan[1].split(":");
            int next = Integer.parseInt(parseTime[0]) * 60 + Integer.parseInt(parseTime[1]);
            
            while (stack.empty() == false) {
                String name = stack.peek();
                int time = map.get(name);
                
                int remain = cur + time - next;
                if (remain > 0) {
                    map.put(name, remain);
                    break;
                }
                else {
                    cur += time;
                    answer[idx++] = name;
                    stack.pop();
                }
            }
            
            cur = next;
            stack.push(plan[0]);
            map.put(plan[0], Integer.parseInt(plan[2]));
        }
        
        while (stack.empty() == false)
            answer[idx++] = stack.pop();
        
        return answer;
    }
}
