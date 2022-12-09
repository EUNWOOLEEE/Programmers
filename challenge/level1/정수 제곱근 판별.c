#include <stdio.h>

long long solution(long long n)
{
    for(long long i = 1; i * i <= n; i++)
    {
        if(i * i == n)
        {
            i++;
            return i * i;
        }
    }
    return -1;
}