import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] splited = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(splited, this::compare);
        
        HashSet<String> checkNum = new HashSet<>();
        int[] answer = new int[splited.length];
        
        for (int i = 0; i < splited.length; i++)
            for (String str : splited[i].split(","))
                if (checkNum.add(str) == true)
                    answer[i] = Integer.parseInt(str);
            
        return answer;
    }
    
    private int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}