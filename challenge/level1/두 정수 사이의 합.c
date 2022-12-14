#include <stdio.h>

long long solution(int a, int b)
{
    long long ans = 0;
    
    if(a > b)
        while(a >= b)
            ans += a--;
    else
        while(b >= a)
            ans += b--;
    
    return ans;
}