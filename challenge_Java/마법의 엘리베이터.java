class Solution {
    public int solution(int storey) {
        String str = Integer.toString(storey);
        int[] arr = new int[str.length() + 1];
        
        for (int i = str.length() - 1; i >= 0; i--)
            arr[i + 1] = str.charAt(i) - '0';
        
        int answer = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 5) {
                answer += 10 - arr[i];
                arr[i - 1]++;
            }
            else if (arr[i] < 5) {
                answer += arr[i];
            }
            else {
                if (arr[i - 1] >= 5) {
                    answer += 10 - arr[i];
                    arr[i - 1]++;
                }
                else {
                    answer += arr[i];
                }
            }
        }
        return answer;
    }
}
