class Solution {
    public int[] solution(int brown, int yellow) {
        for (int col = 3; ; col++) {
            int row = (brown - col * 2) / 2 + 2;
            if ((row - 2) * (col - 2) == yellow)
                return new int[]{row, col};
        }
    }
}
