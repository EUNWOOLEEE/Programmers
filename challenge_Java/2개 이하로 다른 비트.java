class Solution {
    public long f(long num) {
        StringBuilder str = new StringBuilder(Long.toBinaryString(num));
        
        int zeroIdx = -1;
        for (int i = str.length() - 1; i >= 0; i--)
            if (zeroIdx == -1 && str.charAt(i) == '0')
                zeroIdx = i;
        
        if (zeroIdx == str.length() - 1)
            return num + 1;
        
        if (zeroIdx == -1) {
            str.append('1');
            str.setCharAt(1, '0');
        }
        else {
            str.setCharAt(zeroIdx, '1');
            str.setCharAt(zeroIdx + 1, '0');
        }
        
        return Long.parseLong(str.toString(), 2);
    }
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++)
            answer[i] = f(numbers[i]);
        
        return answer;
    }
}
