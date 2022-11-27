#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b)
{
    int *A = (int *)a;
    int *B = (int *)b;
    
    if(*A > *B)
        return -1;
    else if(*A < *B)
        return 1;
    return 0;
}

int solution(int k, int m, int score[], size_t score_len)
{
    int ans = 0;
    
    qsort(score, score_len, sizeof(int), cmp);

    int cnt = 0;
    for(int i = 0; i < score_len; i++)
    {
        cnt++;
        if(cnt == m)
        {
            ans += score[i] * m;
            cnt = 0;
        }
    }
    return ans;
}