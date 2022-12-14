#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* solution(int a, int b)
{
    int cnt = 0;
    char* ans = (char*)malloc(4);
    char days[8][4] = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    int months[13] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    for(int i = 1; i < a; i++)
        cnt += months[i];
    
    strcpy(ans, days[(cnt + b) % 7]);
    ans[4] = '\0';
    
    return ans;
}