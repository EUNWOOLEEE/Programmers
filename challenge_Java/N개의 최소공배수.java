import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        for (int i = 2, j; ; i++) {
            int LCM = arr[arr.length - 1] * i;
            
            for (j = 0; j < arr.length - 1 && LCM % arr[j] == 0; j++) {}
            
            if (j == arr.length - 1)
                return LCM;
        }
    }
}
