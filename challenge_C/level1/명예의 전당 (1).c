#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

int* solution(int k, int score[], size_t score_len)
{
    int *top = (int *)malloc(sizeof(int) * k);
    int *ans = (int *)malloc(sizeof(int) * 1000);
    
    int idx = 0, min = 2000;
    for(; idx < k; idx++) //k일까지는 min값 찾기
    {
        if(min > score[idx])
            ans[idx] = min = score[idx];
        else
            ans[idx] = min;
        top[idx] = score[idx];
    }
    qsort(top, k, sizeof(int), cmp);
    
    for(; idx < score_len; idx++)
    {
        if(top[0] < score[idx])
        {
            top[0] = score[idx];        
            qsort(top, k, sizeof(int), cmp);
        }
        ans[idx] = top[0];
    }
    return ans;
}