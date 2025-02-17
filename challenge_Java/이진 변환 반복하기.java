class Solution {
    private int zeroCount = 0;
    private int convertCount = 0;
    
    public int[] solution(String s) {
        while (s.equals("1") == false) {
            s = Integer.toBinaryString(convert(s).length());
            convertCount++;
        }
        return new int[]{convertCount, zeroCount};
    }
    
    private String convert(String s) {
        String temp = "";
        for (char c : s.toCharArray())
            if (c == '1') temp += "1";
        
        zeroCount += s.length() - temp.length();
        return temp;
    }
}
