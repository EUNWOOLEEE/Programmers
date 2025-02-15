#include <stdio.h>
#include <stdlib.h>

int* solution(long long n)
{
    int idx = 0;
    int tmp[11] = {0,};
    
    for(; n; n /= 10)
        tmp[idx++] = n % 10;
    
    
    int *ans = (int *)malloc(sizeof(int) * idx);
    
    while(idx--)
        ans[idx] = tmp[idx];
    
    return ans;
}