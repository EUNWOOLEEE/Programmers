class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < arr1.length; row++)
            for (int col = 0; col < arr2[0].length; col++)
                for (int common = 0; common < arr1[0].length; common++)
                    answer[row][col] += arr1[row][common] * arr2[common][col];
        return answer;
    }
}