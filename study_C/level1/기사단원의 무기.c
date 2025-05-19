#include <stdio.h>

int measure(int num)
{
    int cnt = 2;
    
    if (num == 1)
        return 1;
    
    for(int i = 2; i <= num / 2; i++)
        if(!(num % i))
            cnt++;
    return cnt;
}

int solution(int number, int limit, int power)
{
    int res, ans = 0;
    
    for(int i = 1; i <= number; i++)
    {
        res = measure(i);
        if(res > limit)
            ans += power;
        else
            ans += res;
    }
    return ans;
}