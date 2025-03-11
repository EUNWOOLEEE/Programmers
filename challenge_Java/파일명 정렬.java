import java.util.Arrays;

class Solution {
    public int compare(String a, String b) {
        a = a.toUpperCase();
        b = b.toUpperCase();
        
        int idxA = 0, idxB = 0;
        for (; idxA < a.length() && Character.isDigit(a.charAt(idxA)) == false; idxA++) {}
        for (; idxB < b.length() && Character.isDigit(b.charAt(idxB)) == false; idxB++) {}
        
        String subA = a.substring(0, idxA);
        String subB = b.substring(0, idxB);

        if (subA.equals(subB) == false)
            return subA.compareTo(subB);
        
        int numIdxA = idxA, numIdxB = idxB;
        for (; numIdxA < a.length() && Character.isDigit(a.charAt(numIdxA)) == true; numIdxA++) {}
        for (; numIdxB < b.length() && Character.isDigit(b.charAt(numIdxB)) == true; numIdxB++) {}
        
        return Integer.parseInt(a.substring(idxA, numIdxA)) - Integer.parseInt(b.substring(idxB, numIdxB));
    }
    
    public String[] solution(String[] files) {
        Arrays.sort(files, this::compare);
        return files;
    }
}
