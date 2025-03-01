class Solution {
    public int solution(int[] pri, int location) {
        int[] nums = new int[10];
        int head = 0, answer = 1;
        int len = pri.length;
        
        for (int i = 0; i < pri.length; i++)
            nums[pri[i]]++;

        while (true) {
            if (pri[head] != 0 && existHighNum(nums, pri[head]) == false) {
                if (head == location)
                    break;
                nums[pri[head]]--;
                pri[head] = 0;
                answer++;
            }
            head = (head + 1) % len;
        }
        
        return answer;
    }
    
    private Boolean existHighNum(int[] nums, int num) {
        for (int i = num + 1; i < 10; i++)
            if (nums[i] > 0)
                return true;
        return false;
    }
}