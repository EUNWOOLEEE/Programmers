import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // key-차량 번호
        // value-[입차 시간, 누적 시간, 출차 여부]
        TreeMap<String, int[]> parkingLot = new TreeMap<>();
        
        for (String str : records) {
            String[] splited = str.split(" ");
            int time = parseTime(splited[0].split(":"));
            
            if (parkingLot.containsKey(splited[1]) == false)
                parkingLot.put(splited[1], new int[3]);
            int[] carInfo = parkingLot.get(splited[1]);
            
            if (splited[2].equals("IN") == true) {
                carInfo[0] = time;
                carInfo[2] = 1;
            }
            else {
                carInfo[1] += time - carInfo[0];
                carInfo[0] = 0;
                carInfo[2] = 0;
            }
        }
        
        int idx = 0;
        int maxTime = parseTime(new String[]{"23", "59"});
        int[] answer = new int[parkingLot.size()];
        
        for (String key : parkingLot.keySet()) {
            int[] value = parkingLot.get(key);
            
            if (value[2] == 1)
                value[1] += maxTime - value[0];
            
            answer[idx] = fees[1];
            
            if (value[1] > fees[0]) {
                value[1] -= fees[0];
                answer[idx] += value[1] / fees[2] * fees[3];
                answer[idx] += value[1] % fees[2] != 0 ? fees[3] : 0;
            }
            idx++;
        }
        
        return answer;
    }
    
    public int parseTime(String[] timeInfo) {
        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }
}