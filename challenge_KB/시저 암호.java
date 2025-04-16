class Solution {
    public String solution(String s, int n) {
        char[] result = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = c + n;

            if (Character.isUpperCase(c) == true)
                num = num > 'Z' ? num - 26 : num;
            else if ((Character.isLowerCase(c) == true))
                num = num > 'z' ? num - 26 : num;
            else
                num = ' ';
            result[i] = (char)num;
        }
        return new String(result);
    }
}
