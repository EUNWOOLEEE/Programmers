#include <stdio.h>

int arr[2001] = {0,};

int DP(int n)
{
    arr[1] = 1;
    arr[2] = 2;
    
    for(int i = 3; i <= n; i++)
        arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
    return arr[n];
}

long long solution(int n)
{
    return DP(n);
}