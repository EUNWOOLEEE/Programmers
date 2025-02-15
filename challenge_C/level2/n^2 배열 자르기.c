#include <stdio.h>
#include <stdlib.h>

int* solution(int n, long long left, long long right)
{
    int idx = 0;
    int* ans = (int*)calloc(right - left + 1, sizeof(int));

    // i / n == 행, i % n == 열
    // 인덱스 값으로 계산해서 행, 열 중 더 큰 값 +1로 넣어줌
    for(long long i = left; i <= right; i++)
        ans[idx++] = (i / n) > (i % n) ? (i / n + 1) : (i % n + 1);
    
    return ans;
}