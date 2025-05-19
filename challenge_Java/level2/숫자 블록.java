class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        int idx = 0;
        
        for (long block = begin; block <= end; block++) {
            if (block == 1) {
                answer[idx++] = 0;
                continue;
            }
            
            int num = 1;
            for (int i = 2; i * i <= block; i++) {
                if (block % i == 0) {
                    if (block / i <= 10000000) {
                        num = (int)block / i;
                        break;
                    }
                    num = i;
                }
            }
            answer[idx++] = num;
        }
        return answer;
    }
}
