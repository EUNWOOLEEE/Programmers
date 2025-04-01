import java.util.*;

class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    public int[] sizes = new int[11];
    
    public String[] solution(String[] orders, int[] course) {
        for (int size : course)
            sizes[size]++;
        
        for (String order : orders) {
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            dfs(new String(charArr), new StringBuilder(), 0);
        }

        ArrayList<String> res = new ArrayList<>();
        for (String str : map.keySet())
            if (sizes[str.length()] > 1 && map.get(str) == sizes[str.length()])
                res.add(str);
        
        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }
    
    public void dfs(String order, StringBuilder str, int idx) {
        for (int i = idx; i < order.length(); i++) {
            str.append(order.charAt(i));
            String tmp = str.toString();
            int cnt = map.getOrDefault(tmp, 0) + 1;
            
            if (sizes[str.length()] > 0) {
                map.put(tmp, cnt);
                sizes[str.length()] = sizes[str.length()] > cnt ? sizes[str.length()] : cnt;
            }
            
            dfs(order, str, i + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
