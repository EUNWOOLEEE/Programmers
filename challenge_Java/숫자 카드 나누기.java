import java.util.Arrays;

class Solution {
    public boolean checkNum(int[] other, int num) {
        for (int i = 0; i < other.length; i++)
            if (other[i] % num == 0)
                return false;
        return true;
    }
    
    public int findNum(int[] array, int[] other, int num) {
        int idx = 0;
        for (; num > 1; num--) {
            for (idx = 0; idx < array.length; idx++) {
                if (array[idx] % num != 0)
                    break;
            }
            
            if (idx == array.length && checkNum(other, num) == true)
                break;
        }

        return idx == array.length ? num : 0;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int a = findNum(arrayA, arrayB, arrayA[0]);
        int b = findNum(arrayB, arrayA, arrayB[0]);
        int answer = a > b ? a : b;
        return answer == 1 ? 0 : answer;
    }
}
