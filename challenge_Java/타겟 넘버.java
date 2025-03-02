class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int cur, int idx) {
        if (idx == numbers.length) {
            answer = cur == target ? answer + 1: answer;            
            return;
        }
        dfs(numbers, target, cur + numbers[idx], idx + 1);
        dfs(numbers, target, cur - numbers[idx], idx + 1);
    }
}