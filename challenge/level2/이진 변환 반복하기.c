#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int search_one(char *bi)
{
    int cnt = 0;
    
    for(; *bi; bi++)
        if(*bi == '1') cnt++;
    
    return cnt;
}

int search_zero(char *bi)
{
    int cnt = 0;
    
    for(; *bi; bi++)
        if(*bi == '0') cnt++;
    
    return cnt;
}

char *to_binary(int num)
{
    int len = 0;
    for(int tmp = num; tmp; tmp /= 2) len++;
    
    char *res = (char *)calloc(len, sizeof(char));
    for(int i = len - 1; num; num /= 2)
        res[i--] = (num % 2) + '0';
    
    return res;
}

int* solution(const char* s)
{
    int* ans = (int*)calloc(2, sizeof(int));
    char *bi = strdup(s);
    
    int zero = 0, one = 2; //반복문에 들어가기 위해 2로 초기화
    while(one > 1)
    {
        zero = search_zero(bi); //제거할 0의 개수
        one = search_one(bi); //남은 1의 개수(== 길이)
        
        ans[0]++;
        ans[1] += zero;
        bi = to_binary(one);
    }
    
    return ans;
}