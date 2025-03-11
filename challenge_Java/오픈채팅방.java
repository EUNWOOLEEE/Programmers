import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        ArrayList<String[]> result = new ArrayList<>();
        // [0]: ID
        // [1]: enter == 1 / leave == 0
        
        for (String str : record) {
            String[] splited = str.split(" ");
            
            if (splited[0].equals("Leave") == true) {
                result.add(new String[]{splited[1], "0"});
                continue;
            }
            else if (splited[0].equals("Enter") == true)
                result.add(new String[]{splited[1], "1"});
            
            users.put(splited[1], splited[2]);
        }
            
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            String[] cur = result.get(i);
            
            answer[i] = users.get(cur[0]);
            answer[i] += cur[1].equals("1") == true ? "님이 들어왔습니다." : "님이 나갔습니다.";
        }
        
        return answer;
    }
}