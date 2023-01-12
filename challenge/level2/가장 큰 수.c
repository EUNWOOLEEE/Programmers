#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int cnt_digit(int n)
{
    int cnt = 0;

    if(!n) return 1;
    for(; n; n /= 10) cnt++;
    return cnt;
}

//두개 이어붙여보고 더 큰 수가 되는 방법으로 반환하기
int cmp(const void *A, const void *B)
{
    int a = *(int *)A;
    int b = *(int *)B;
    int n1, n2;
    
    n1 = a * pow(10, cnt_digit(b)) + b;
    n2 = b * pow(10, cnt_digit(a)) + a;
    
    return n2 - n1;
}

char* solution(int numbers[], size_t numbers_len)
{
    int size = 0, zero = 0;
    for(int i = 0; i < numbers_len; i++)
    {
        if(!numbers[i]) zero++;
        size += cnt_digit(numbers[i]);
    }
    
    if(zero == numbers_len)
        return strdup("0");
    
    
    qsort(numbers, numbers_len, sizeof(int), cmp);
    
    char* ans = (char*)calloc(size + 1, sizeof(char));
    

    int idx = 0;
    for(int i = 0; i < numbers_len; i++)
    {
        int j = idx + cnt_digit(numbers[i]);

        if(!numbers[i])
            ans[--j] = '0';

        for(int num = numbers[i]; num; num /= 10)
            ans[--j] = num % 10 + '0';

        idx += cnt_digit(numbers[i]);
    }
    ans[idx] = '\0';
    
    return ans;
}