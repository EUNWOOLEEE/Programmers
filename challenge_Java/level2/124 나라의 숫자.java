class Solution {
    public String solution(int n) {
        String[] arr = {"1", "2", "4"};
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            n--;
            answer.insert(0, arr[n % 3]);
            n /= 3;
        }
        return answer.toString();
    }
}
