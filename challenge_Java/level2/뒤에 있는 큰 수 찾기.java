import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        boolean flag = false;
        
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) { // 뒤 숫자가 더 클 때
                answer[i] = numbers[i + 1];
                flag = true;
            }
            
            else if (numbers[i] == numbers[i + 1]) // 뒤 숫자랑 같을 때
                answer[i] = answer[i + 1];
            
            else if (flag == true) // 뒤 숫자가 더 작고 -1만 있지 않을 때
                for (int j = i; j < numbers.length; j++)
                    if (numbers[i] < answer[j]) {
                        answer[i] = answer[j];
                        break;
                    }
        }
        return answer;
    }

    // 업데이트 안 된 인덱스를 리스트로 관리하는 방법 (시간초과)

    // public int[] solution(int[] numbers) {
    //     LinkedList<Integer> list = new LinkedList<>();
    //     int[] answer = new int[numbers.length];
    //     Arrays.fill(answer, -1);
        
    //     for (int i = 1; i < numbers.length; i++) {
    //         for (int j = 0; j < list.size(); j++) {
    //             int numIdx = list.get(j);
    //             if (numbers[numIdx] < numbers[i]) {
    //                 answer[numIdx] = numbers[i];
    //                 list.remove(j--);
    //             }
    //         }
    //         if (numbers[i - 1] < numbers[i])
    //             answer[i - 1] = numbers[i];
    //         else
    //             list.add(i - 1);
    //     }
    //     return answer;
    // }
}
