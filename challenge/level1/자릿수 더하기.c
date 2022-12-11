#include <stdio.h>

int solution(int n)
{
    int ans = 0;
    
    for(; n; n /= 10)
        ans += n % 10;
    
    return ans;
}