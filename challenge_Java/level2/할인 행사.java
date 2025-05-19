import java.util.HashMap;

class Solution {
    private HashMap<String, Integer> items = new HashMap<>();
    private int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int total = 0;
        for (int i = 0; i < want.length; i++) {
            items.put(want[i], number[i]);
            total += number[i];           
        }

        for (int day = 0; day < total; day++)
            if (items.containsKey(discount[day]))
                items.replace(discount[day], items.get(discount[day]) - 1);
        checkPurchasable(want);
        
        for (int left = 0, right = total; right < discount.length; left++, right++) {
            if (items.containsKey(discount[left]))
                items.replace(discount[left], items.get(discount[left]) + 1);
            if (items.containsKey(discount[right]))
                items.replace(discount[right], items.get(discount[right]) - 1);
            checkPurchasable(want);
        }
        
        return answer;
    }
    
    private void checkPurchasable(String[] want) {
        for (int i = 0; i < want.length; i++)
            if (items.get(want[i]) > 0)
                return;
        answer++;
    }
}