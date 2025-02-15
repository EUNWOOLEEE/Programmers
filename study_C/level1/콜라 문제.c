#include <stdio.h>

int solution(int a, int b, int n)
{
    int ans = 0, rest = 0;
    
    while(n >= a)
    {
        rest += n % a;
        n = (n / a) * b;
        ans += n;    
        n += rest;
        rest = 0;
    }
    
    return ans;
}