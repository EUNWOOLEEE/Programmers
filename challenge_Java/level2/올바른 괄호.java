class Solution {
    boolean solution(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') res++;
            else res--;
            if (res < 0) return false;
        }
        return res == 0;
    }
}
