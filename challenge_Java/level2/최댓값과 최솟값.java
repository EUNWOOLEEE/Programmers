import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (String num : s.split(" "))
            nums.add(Integer.parseInt(num));
        Collections.sort(nums);
        return nums.get(0) + " " + nums.get(nums.size() - 1);
    }
}