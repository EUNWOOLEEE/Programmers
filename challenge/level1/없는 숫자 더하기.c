#include <stdio.h>

int solution(int numbers[], size_t numbers_len)
{
    int ans = 45;
    
    for(int i = 0; i < numbers_len; i++)
        ans -= numbers[i];
    return ans;
}