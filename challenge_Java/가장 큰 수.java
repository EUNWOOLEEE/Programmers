import java.util.Arrays;

class Solution {
    public int compare(String str1, String str2) {
        String tmp1 = str1 + str2;
        String tmp2 = str2 + str1;
        
        return tmp2.compareTo(tmp1);
    }
    
    public String solution(int[] numbers) {        
        String[] strs = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++)
            strs[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(strs, this::compare);
        
        if (strs[0].equals("0") == true)
            return "0";
        
        String answer = "";
        for (String str : strs)
            answer += str;
        
        return answer;
    }
}
