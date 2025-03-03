class Solution {
    public int solution(int[] topping) {
        int[] first = new int[100001];
        int[] second = new int[100001];
        int firstNum = 0, secondNum = 0;
        
        for (int i = 0; i < topping.length; i++) {
            if (second[topping[i]] == 0)
                secondNum++;
            second[topping[i]]++;
        }
        
        int answer = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            firstNum = first[topping[i]] == 0 ? firstNum + 1 : firstNum;
            first[topping[i]]++;
            second[topping[i]]--;
            secondNum = second[topping[i]] == 0 ? secondNum - 1 : secondNum;
            
            answer = firstNum == secondNum ? answer + 1 : answer;
        }
        return answer;
    }
}