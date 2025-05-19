import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++)
            lcm = lcm * arr[i] / getGcd(lcm, arr[i]);
        return lcm;
    }
    
    private int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
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