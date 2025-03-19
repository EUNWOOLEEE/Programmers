class Solution {
    public boolean[] visitedNum = new boolean[10000000];
    public int answer = 0;
        
    public int isPrime(int num) {
        if (visitedNum[num] == true)
            return 0;
        visitedNum[num] = true;
        
        if (num == 2)
            return 1;
        if (num <= 1 || num % 2 == 0)
            return 0;
        
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0)
                return 0;
        
        return 1;
    }
    
    public void dfs(char[] arr, int curIdx, String str, boolean[] visitedIdx) {
        if (curIdx == arr.length)
            return;
        
        answer += isPrime(Integer.parseInt(str));
        
        for (int i = 0; i < arr.length; i++) {
            if (visitedIdx[i] == true)
                continue;
            
            boolean[] tmp = visitedIdx.clone();
            tmp[i] = true;
            
            if (str.length() < arr.length)
                dfs(arr, i, str + arr[i], tmp);
        }
    }
    
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            boolean[] tmp = new boolean[arr.length];
            tmp[i] = true;
            dfs(arr, i, String.valueOf(arr[i]), tmp);
        }
        return answer;
    }
}
