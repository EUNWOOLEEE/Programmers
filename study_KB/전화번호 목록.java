// HashMap
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();
        Arrays.sort(phone_book);
        
        for (String phone : phone_book) {
            for (int len = 1; len < phone.length(); len++) {
                String str = phone.substring(0, len);
                if (map.containsKey(str) == true)
                    return false;
            }
            map.put(phone, true);
        }
        return true;
    }
}

// startsWith
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++)
            if (phone_book[i + 1].startsWith(phone_book[i]) == true)
                return false;
        return true;
    }
}
