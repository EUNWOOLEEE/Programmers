import java.util.Arrays;

class Solution {
    public long[] solution(int n, long left, long right) {
        long[] array = new long[(int)(right - left) + 1];
        
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            array[(int)(i - left)] = col < row ? row + 1 : col + 1;
        }
        
        return array;
    }
}