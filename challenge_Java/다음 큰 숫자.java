class Solution {
    public int solution(int n) {
        int bitOfN = Integer.bitCount(n);
        int next = n + 1;
        for (; bitOfN != Integer.bitCount(next); next++) {}
        return next;
    }
    
//     public int solution(int n) {
//         int oneOfN = countOne(n);
        
//         int next = n + 1;
//         for (; oneOfN != countOne(next); next++) {}
//         return next;
//     }
    
//     private int countOne(int num) {
//         int count = 0;
//         for (char c : Integer.toBinaryString(num).toCharArray())
//             if (c == '1') count++;
//         return count;
//     }
}
