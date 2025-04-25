class Solution {
    public boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, 0);
        for (int i = 0; i < visited.length; i++)
            if (visited[i] == false)
                return false;
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int cur) {
        List<Integer> keys = rooms.get(cur);

        for (int key : keys) {
            if (visited[key] == false) {
                visited[key] = true;
                dfs(rooms, key);
            }
        }
    }
}
