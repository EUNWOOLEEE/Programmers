class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] checkNums = new int[1000001];
        
        for (int start = 0; start < elements.length; start++) {
            int total = 0;
            for (int next = start; next < start + elements.length; next++) {
                total += elements[next % elements.length];
                if (checkNums[total] == 0) {
                    answer++;
                    checkNums[total]++;
                }
            }
        }
        return answer;
    }
}