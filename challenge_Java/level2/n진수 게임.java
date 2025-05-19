class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int turn = 1;
        
        for (int i = 0; t > 0; i++) {
            String num = Integer.toString(i, n);
            for (int j = 0; j < num.length() && t > 0; j++) {
                if (turn == p) {
                    answer += num.charAt(j);
                    t--;
                }
                turn = (turn % m) + 1;
            }
        }
        return answer.toUpperCase();
    }
}