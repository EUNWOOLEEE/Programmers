import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++)
            gcd = gcd * arr[i] / getLcm(Math.max(gcd, arr[i]), Math.min(gcd, arr[i]));
        return gcd;
    }
    
    private int getLcm(int a, int b) {
        if (b == 0) return a;
        return getLcm(b, a % b);
    }

    // public int solution(int[] arr) {
    //     Arrays.sort(arr);
        
    //     for (int i = 2, j; ; i++) {
    //         int LCM = arr[arr.length - 1] * i;
            
    //         for (j = 0; j < arr.length - 1 && LCM % arr[j] == 0; j++) {}
            
    //         if (j == arr.length - 1)
    //             return LCM;
    //     }
    // }
}