
import java.util.*;

class Solution {
    public int height, width;
    public char[][] board;
    public int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
    public int solution(String[] storage, String[] requests) {
        height = storage.length;
        width = storage[0].length();
        board = new char[height][width];
        
        // int[] 좌표값
        // LinkedList 알파벳 별 좌표값 목록
        // HashMap 모든 알파벳
        HashMap<Character, LinkedList<int[]>> map = new HashMap<>();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Character c = storage[row].charAt(col);
                
                map.put(c, map.getOrDefault(c, new LinkedList<>()));
                map.get(c).add(new int[]{row, col});
                board[row][col] = c;
            }
        }
        
        for (String request : requests) {
            char c = request.charAt(0);
            LinkedList<int[]> list = map.get(c);
            
            if (map.containsKey(c) == false)
                continue;
            
            if (request.length() > 1) {
                for (int[] pos : list)
                    board[pos[0]][pos[1]] = '-';
                list.clear();
            }
            else {
                Iterator<int[]> it = list.iterator();
                LinkedList<int[]> toRemove = new LinkedList<>();
                
                while (it.hasNext()) {
                    int[] pos = it.next();
                    if (bfs(pos) == true)
                        toRemove.add(pos);
                }
                
                for (int[] pos : toRemove)
                    board[pos[0]][pos[1]] = '-';
                list.removeAll(toRemove);
            }
        }
        
        int answer = 0;
        for (Character c : map.keySet())
            answer += map.get(c).size();
        
        return answer;
    }
        
    public boolean bfs(int[] pos) {
        boolean[][] visited = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pos);
        
        while (queue.size() > 0) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dir[i][0], cur[1] + dir[i][1]};
                
                if (isOutOfBound(next) == true)
                    return true;
                
                if (isValidPos(next, visited) == true) {
                    queue.add(next);
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        return false;
    }
        
    public boolean isOutOfBound(int[] pos) {
        return (pos[0] < 0 || height <= pos[0]
                || pos[1] < 0 || width <= pos[1]);
    }
    
    public boolean isValidPos(int[] pos, boolean[][] visited) {
        return (0 <= pos[0] && pos[0] < height
                && 0 <= pos[1] && pos[1] < width
                && visited[pos[0]][pos[1]] == false
                && board[pos[0]][pos[1]] == '-');
    }
}
