import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        HashSet<String> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (set.add(city) == true)
                answer += 5;
            else {
                list.remove(city);
                answer += 1;
            }
            
            list.add(city);
            
            if (list.size() > cacheSize) {
                set.remove(list.get(0));
                list.remove(0);
            }
        }
        
        return answer;
    }
}