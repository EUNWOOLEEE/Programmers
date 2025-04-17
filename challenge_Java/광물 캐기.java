class Solution {
    public int answer = Integer.MAX_VALUE;
    public int end;
    public int[][] arr = {{1, 1, 1},
                          {5, 1, 1},
                          {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        for (int i = 0; i < 3; i++)
            end += picks[i] * 5;
        dfs(picks, minerals, 0, 0);
        return answer;
    }
    
    public void dfs(int[] picks, String[] minerals, int fatigue, int idx) {
        if (idx >= end) {
            answer = answer < fatigue ? answer : fatigue;
            return ;
        }
        
        for (int i = 0; i < 3; i++) {
            int[] newPicks = picks.clone();
            if (newPicks[i] == 0)
                continue;
            newPicks[i]--;
            
            int newFatigue = fatigue;
            for (int j = idx; j < idx + 5 && j < minerals.length; j++) {
                if (minerals[j].equals("diamond") == true)
                    newFatigue += arr[i][0];
                else if (minerals[j].equals("iron") == true)
                    newFatigue += arr[i][1];
                else
                    newFatigue += arr[i][2];
            }
            
            dfs(newPicks, minerals, newFatigue, idx + 5);
        }
    }
}

