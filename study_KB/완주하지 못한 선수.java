// HashMap
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str : participant)
            map.put(str, map.getOrDefault(str, 0) + 1);
        
        for (String str : completion)
            map.put(str, map.get(str) - 1);
        
        for (String key : map.keySet())
            if (map.get(key) != 0)
                return key;
        
        return "";
    }
}

// 정렬 후 순회
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < participant.length; i++)
            if (i == completion.length || participant[i].equals(completion[i]) == false)
                return participant[i];
        
        return "";
    }
}
