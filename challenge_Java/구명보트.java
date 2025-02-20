import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0, right = people.length - 1;
        Arrays.sort(people);
        
        for (int total = 0, cnt = 0; left < right; answer++) {
            for (; cnt < 2 && right >= left && total + people[right] <= limit; cnt++)
                total += people[right--];
            for (; cnt < 2 && left < right && total + people[left] <= limit; cnt++)
                total += people[left++];
            total = cnt = 0;
        }
        
        return right < left ? answer : answer + 1;
    }
}
