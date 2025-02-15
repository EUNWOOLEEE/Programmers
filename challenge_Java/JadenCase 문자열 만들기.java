class Solution {
    public String solution(String s) {
        String answer = "";
        for (char c : s.toCharArray()) {
            if (answer == "" || answer.charAt(answer.length() - 1) == ' ')
                answer += Character.toUpperCase(c);
            else
                answer += Character.toLowerCase(c);
        }
        return answer;
    }
}
