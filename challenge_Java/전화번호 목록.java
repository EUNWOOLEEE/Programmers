import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> uniqueNumbers = new HashSet<>();
        
        Arrays.sort(phone_book, (a, b) -> { return a.length() -b.length(); });
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (uniqueNumbers.contains(phone_book[i].substring(0, j)) == true)
                    return false;
            }
            uniqueNumbers.add(phone_book[i]);
        }
            
        return true;
    }

	// public boolean solution(String[] phone_book) {
    //     Arrays.sort(phone_book);
        
    //     for (int i = 0; i < phone_book.length - 1; i++)
    //         if (phone_book[i + 1].startsWith(phone_book[i]) == true)
    //             return false;
        
    //     return true;
    // }
}