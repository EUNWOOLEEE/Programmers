#include <stdio.h>

int get_measure(int n)
{    
    int cnt = 1;

    for(int i = 1; i <= n / 2; i++)
        if(!(n % i))
            cnt++;
    return cnt;
}

int solution(int left, int right)
{
    int ans = 0;
    
    for(int i = left; i <= right; i++)
    {
        if(get_measure(i) % 2)
            ans -= i;
        else
            ans += i;
    }
    return ans;
}