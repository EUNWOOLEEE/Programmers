#include <stdio.h>

int solution(int n)
{
    int ans = !n ? 0 : 1 + n;
    
    for(int i = 2; i <= n / 2; i++)
        if(!(n % i))
            ans += i;

    return n == 1 ? 1 : ans;
}