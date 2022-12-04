#include <stdio.h>

int arr[17];
int ans = 0, idx = 0;

void to_ternary(int n)
{
    for(idx = 0; n; idx++)
    {
        arr[idx] = n % 3;
        n /= 3;
    }
}

void to_decimal(void)
{
    int power = 1;

    while(idx--)
    {
        ans += power * arr[idx];
        power *= 3;
    }
}

int solution(int n)
{
    to_ternary(n);
    to_decimal();
    
    return ans;
}