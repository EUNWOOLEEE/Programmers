import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (map.containsKey(city) == false || map.get(city) < 1) {
                map.put(city, 1);
                answer += 5;
            }
            else {
                list.remove(city);
                answer += 1;
            }
            
            list.add(city);
            
            if (list.size() > cacheSize) {
                map.put(list.get(0), map.get(list.get(0)) - 1);
                list.remove(0);
            }
        }
        
        return answer;
    }
}