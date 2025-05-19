import java.util.*;

class Solution {
    public int parseTime(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public int solution(String[][] book_time) {
        ArrayList<Integer> room = new ArrayList<>();
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for (String[] book_info : book_time) {
            int in = parseTime(book_info[0].split(":"));
            int out = parseTime(book_info[1].split(":"));
            
            int idx = 0;
            for (; idx < room.size(); idx++) {
                if (room.get(idx) <= in) {
                    room.set(idx, out + 10);
                    break;
                }
            }
            if (idx == room.size())
                room.add(out + 10);
        }
        
        return room.size();
    }
}
