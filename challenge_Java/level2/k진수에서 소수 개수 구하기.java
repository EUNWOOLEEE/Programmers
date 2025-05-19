class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        for (String s : Integer.toString(n, k).split("0"))
            if (s.length() != 0 && isPrime(Long.parseLong(s)) == true)
                answer++;
        
        return answer;
    }
    
    public Boolean isPrime(long num) {
        if (num == 2) return true;
        if (num <= 1 || num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i += 2)
            if (num % i == 0)
                return false;
        return true;
    }
}