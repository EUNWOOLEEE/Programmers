import java.util.*;

class Solution {
    public int[] visited;
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        int idx = 0;
        for (; idx < coins.length && coins[idx] <= amount; idx++) {}
        visited = new int[amount + 1];
        bfs(coins, amount, idx);

        return visited[amount] == 0 ? -1 : visited[amount];
    }

    public void bfs(int[] coins, int amount, int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (queue.size() > 0) {
            int cur = queue.poll();

            for (int i = 0; i < idx; i++) {
                int next = cur + coins[i];
                if (next == amount) {
                    visited[next] = visited[cur] + 1;
                    return;
                }
                if (next < amount && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
