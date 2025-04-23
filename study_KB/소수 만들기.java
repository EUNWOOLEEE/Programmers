class Solution {
    public int answer = 0;
    
    public boolean isPrime(int num) {
        if (num % 2 == 0)
            return false;
        if (num < 2)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0)
                return false;
        return true;
    }
    
    public int solution(int[] nums) {
        dfs(nums, 0, 0, 0);
        return answer;
    }
    
    public void dfs(int[] nums, int num, int idx, int cnt) {
        if (cnt == 3) {
            answer = isPrime(num) == true ? answer + 1 : answer;
            return;
        }
        
        for (int i = idx; i < nums.length; i++)
            dfs(nums, num + nums[i], i + 1, cnt + 1);
    }
}
