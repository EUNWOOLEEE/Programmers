import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        int num = 1, turn = 1;
        char prev = words[0].charAt(0);
        HashMap<String, Boolean> checkWord = new HashMap<>();

        for (String word : words) {
            if (num == n + 1) {
                num = 1;
                turn++;
            }
            
            if (checkWord.containsKey(word) == true || (word.charAt(0) != prev))
                return new int[]{num, turn};
            
            num++;
            checkWord.put(word, true);
            prev = word.charAt(word.length() - 1);
        }
        
        return new int[]{0, 0};
    }
}