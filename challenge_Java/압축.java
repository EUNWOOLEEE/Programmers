import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dic = new HashMap<>();
        int cnt = 1;
        
        for (char c = 'A'; c <= 'Z'; c++)
            dic.put(String.valueOf(c), cnt++);

        Vector<Integer> answer = new Vector<>();
        for (int idx = 0; idx < msg.length();) {
            int end = idx + 1;
            String prev = "", cur = msg.substring(idx, end);
            
            while (end < msg.length() && dic.containsKey(cur) == true) {
                end++;
                prev = cur;
                cur = msg.substring(idx, end);
            }
            
            if (end == msg.length() && dic.containsKey(cur) == true) {
                answer.add(dic.get(cur));
                break;
            }
            
            answer.add(dic.get(prev));
            dic.put(cur, cnt++);
            idx = end - 1;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}