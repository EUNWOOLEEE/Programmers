import java.util.*;

class Solution {
    class Item {
        public String word;
        public int cnt;
        
        public Item(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(begin, 0));
        
        while (queue.size() > 0) {
            Item cur = queue.poll();
            
            if (cur.word.equals(target) == true)
                return cur.cnt;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i] == false && getDiffCnt(cur.word, words[i]) == 1) {
                    visited[i] = true;
                    queue.add(new Item(words[i], cur.cnt + 1));
                }
            }
        }
        return 0;
    }
    
    public int getDiffCnt(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++)
            cnt = s1.charAt(i) != s2.charAt(i) ? cnt + 1 : cnt;
        return cnt;
    }
}
