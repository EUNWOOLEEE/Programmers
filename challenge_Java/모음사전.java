class Solution {
    public int wordInt = 0, answer = 0, cnt = 0;
    
    public int solution(String word) {
        for (char c : word.toCharArray()) {
            if (c == 'A') wordInt = wordInt * 10 + 1;
            else if (c == 'E') wordInt = wordInt * 10 + 2;
            else if (c == 'I') wordInt = wordInt * 10 + 3;
            else if (c == 'O') wordInt = wordInt * 10 + 4;
            else wordInt = wordInt * 10 + 5;
        }
        
        dfs(0);
        return answer;
    }

    public void dfs(int dic) {
        if (dic == wordInt) {
            answer = cnt;
            return;            
        }
        
        cnt++;
        for (int i = 1; i <= 5; i++)
            if (answer == 0 && dic / 10000 == 0)
                dfs(dic * 10 + i);
    }
}