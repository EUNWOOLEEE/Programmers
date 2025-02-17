class Solution {
    public int solution(int n) {
        int first = 0, second = 1;
        while (n-- > 1) {
            int temp = second;
            second = (first + second) % 1234567;
            first = temp;
        }
        return second;
    }
}
