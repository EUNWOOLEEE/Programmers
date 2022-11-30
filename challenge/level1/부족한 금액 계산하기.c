#include <stdio.h>

long long solution(int price, int money, int count)
{
    long long ans = 0;
    
    while(count)
        ans += price * count--;

    return ans < money ? 0 : (ans - money);
}