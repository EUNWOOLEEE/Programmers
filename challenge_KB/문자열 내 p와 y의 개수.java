class Solution {
    boolean solution(String s) {
        int p = 0, y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') p++;
            else if (c == 'y' || c == 'Y') y++;
        }
        return y == p;
    }
}
