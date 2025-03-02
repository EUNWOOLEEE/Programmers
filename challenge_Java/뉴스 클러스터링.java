import java.util.HashMap;

class Solution {
    private HashMap<String, int[]> similarity = new HashMap<>();
    
    public int solution(String str1, String str2) {
        final int MULTIPLIER = 65536;
            
        splitString(str1.toLowerCase(), 0);
        splitString(str2.toLowerCase(), 1);

        int intersection = 0, union = 0;
        for (int[] arr : similarity.values()) {
            intersection += Math.min(arr[0], arr[1]);
            union += Math.max(arr[0], arr[1]);
        }
        
        return union == 0 ? (int)MULTIPLIER : (int)(intersection / union * MULTIPLIER);
    }
    
    private void splitString(String str, int idx) {
        for (int i = 0; i < str.length() - 1; i++) {
            String newStr = str.substring(i, i + 2);
            
            if (newStr.matches("[a-z]+") == true) {
                if (similarity.containsKey(newStr) == false)
                    similarity.put(newStr, new int[2]);
                similarity.get(newStr)[idx]++;
            }
        }
    }
}