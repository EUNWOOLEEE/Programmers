#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 10000

typedef struct
{
    int hour;
    int min;
    int out; // 출차 내역 유무 플래그, 1 - 미출차, 0 - 출차
} time;

int res[MAX] = {0,};
time times[MAX] = {0,};


int cal_time(int *fees, int num, int hour, int min)
{
    int total = (hour - times[num].hour) * 60;
    total += min - times[num].min;
    return total;
}

int cal_fee(int *fees, int time)
{
	int total = fees[1];
    if(time > fees[0])
    {
        int over = time - fees[0];
        int cnt = 0;
        if(over % fees[2]) cnt++;
        cnt += over / fees[2];
        
        total += cnt * fees[3];
    }
    return total;
}

int* solution(int fees[], size_t fees_len, const char* records[], size_t records_len)
{
    for(int i = 0; i < records_len; i++)
    {
        if(!strncmp(&records[i][11], "IN", 2))
        {
            int num = atoi(&records[i][6]);
            times[num].hour = atoi(&records[i][0]);
            times[num].min = atoi(&records[i][3]);
            times[num].out = 1;
        }
        else
        {
            int num = atoi(&records[i][6]);
            int hour = atoi(&records[i][0]);
            int min = atoi(&records[i][3]);
            
            res[num] += cal_time(fees, num, hour, min);
            times[num].out = 0;
        }
    }
    
    //출차내역 없는 경우 체크
    for(int i = 0; i < MAX; i++)
        if(times[i].out)
            res[i] += cal_time(fees, i, 23, 59);

    
    int idx = 0;
    int* ans = (int*)malloc(sizeof(int) * MAX);

    for(int i = 0; i < MAX; i++)
        if(res[i])
            ans[idx++] = cal_fee(fees, res[i]);
    
    return ans;
}