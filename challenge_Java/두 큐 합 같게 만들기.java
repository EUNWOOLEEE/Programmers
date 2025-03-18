class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length + queue2.length;
        int[] queue = new int[len];
        long total1 = 0, total2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            queue[i] = queue1[i];
            total1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            queue[i + queue1.length] = queue2[i];
            total2 += queue2[i];
        }
        
        int idx1 = 0, idx2 = queue1.length, answer = 0;
        while (idx1 != idx2 && total1 != total2) {
            if (total1 > total2) {
                total1 -= queue[idx1];
                total2 += queue[idx1];
                if (idx1 == len - 1)
                    break;
                idx1 = (idx1 + 1) % len;
            }
            else {
                total2 -= queue[idx2];
                total1 += queue[idx2];
                idx2 = (idx2 + 1) % len;
            }
            answer++;
        }
        
        return total1 == total2 ? answer : -1;
    }
}
