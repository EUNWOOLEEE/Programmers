#include <stdio.h>
#include <stdlib.h>

int solution(int a[], size_t a_len, int b[], size_t b_len)
{
    int ans = 0;
    
    for(int i = 0; i < a_len; i++)
        ans += a[i] * b[i];
    
    return ans;
}