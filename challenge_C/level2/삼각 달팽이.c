#include <stdio.h>
#include <stdlib.h>

int limit, idx, max;
int num = 1, cnt = 1;
int *ans;

void plus_idx()
{
    for(; cnt < limit; cnt++)
    {
        ans[idx] = num++;
        idx += cnt;
    }
    
    if(cnt == limit)
    {
        for(; idx < max && !ans[idx]; idx++)
            ans[idx] = num++;
        idx--;
    }
}

void minus_idx()
{
    for(; !ans[idx - cnt]; cnt--)
    {
        idx -= cnt;
        ans[idx] = num++;
    }
}

int* solution(int n)
{
    limit = n;
    max = n * (n + 1) / 2;
    ans = (int*)calloc(max, sizeof(int));
    
    while(num <= max)
    {
        plus_idx();
        minus_idx();
        idx += cnt++;
        limit--;
    }
    
    return ans;
}