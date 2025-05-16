public class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSeconds(h1, m1, s1);
        int end = toSeconds(h2, m2, s2);
        return countAlarms(end) - countAlarms(start) + (isAlarmTime(start) ? 1 : 0);
    }

    private int toSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    private int countAlarms(int time) {
        int minuteAlarms = time * 59 / 3600;
        int hourAlarms = time * 719 / 43200;
        int twelveOClockAlarms = time >= 43200 ? 2 : 1;
        return minuteAlarms + hourAlarms - twelveOClockAlarms;
    }

    private boolean isAlarmTime(int time) {
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0;
    }
}

