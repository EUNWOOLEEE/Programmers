import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> count = new HashMap<>();
        
        for (String[] tmp : clothes)
            count.put(tmp[1], count.getOrDefault(tmp[1], 0) + 1);
        
        int answer = 1;
        for (Integer i : count.values())
            answer *= i + 1;
        
        return answer - 1;
    }
}