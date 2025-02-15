#include <stdio.h>
#include <stdlib.h>

int cmp1(const void *A, const void *B)
{
    return *(int *)A - *(int *)B;
}

int cmp2(const void *A, const void *B)
{
    int *a = (int *)A;
    int *b = (int *)B;
    
    if(*a > *b)
        return -1;
    return 1;
}

int solution(int A[], size_t A_len, int B[], size_t B_len)
{
    int ans = 0;
    
    qsort(A, A_len, sizeof(int), cmp1);
    qsort(B, B_len, sizeof(int), cmp2);
    
    for(int i = 0; i < A_len; i++)
        ans += A[i] * B[i];

    return ans;
}