// 풀이 실패 -> 시간 초과
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[][] arr = new int[info.length][2];
        for (int i = 0; i < info.length; i++) {
            String[] splited = info[i].split(" ");
            
            arr[i][0] |= (encodeLanguage(splited[0]) << 6);
            arr[i][0] |= (encodeJob(splited[1]) << 4);
            arr[i][0] |= (encodeCareer(splited[2]) << 2);
            arr[i][0] |= encodeFood(splited[3]);
            arr[i][1] = Integer.parseInt(splited[4]);
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] splited = query[i].replace(" and ", " ").split(" ");
            int score = Integer.parseInt(splited[4]);
            int queryMask = 0, filterMask = 0;
            
            if (splited[0].equals("-") == false) {
                queryMask |= (encodeLanguage(splited[0]) << 6);
                filterMask |= (3 << 6);
            }
            
            if (splited[1].equals("-") == false) {
                queryMask |= (encodeJob(splited[1]) << 4);
                filterMask |= (3 << 4);
            }
            
            if (splited[2].equals("-") == false) {
                queryMask |= (encodeCareer(splited[2]) << 2);
                filterMask |= (3 << 2);
            }
            
            if (splited[3].equals("-") == false) {
                queryMask |= encodeFood(splited[3]);
                filterMask |= 3;
            }
            
            int cnt = 0;
            for (int j = 0; j < arr.length; j++)
                if ((arr[j][0] & filterMask) == (queryMask & filterMask) && arr[j][1] >= score)
                    cnt++;
            
            answer[i] = cnt;
        }
        return answer;
    }
    
    public int encodeLanguage(String str) {
        switch (str) {
            case "java": return 0;
            case "python": return 1;
            case "cpp": return 2;
        }
        return 0;
    }
        
    public int encodeJob(String str) {
        switch (str) {
            case "backend": return 0;
            case "frontend": return 1;
        }
        return 0;
    }
    
    public int encodeCareer(String str) {
        switch (str) {
            case "junior": return 0;
            case "senior": return 1;
        }
        return 0;
    }
    
    public int encodeFood(String str) {
        switch (str) {
            case "pizza": return 0;
            case "chicken": return 1;
        }
        return 0;
    }
}
