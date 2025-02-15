#include <stdio.h>
#include <stdlib.h>

int arr[30] = {0,};

int convert(int n, int k) //거꾸로 변환함
{
    int idx = 0;
    
    for(; n; n /= k)
        arr[idx++] = n % k;
    
    return idx;
}

int is_prime(size_t n)
{
    if(n < 2) return 0;
    
    for(size_t i = 2; i * i <= n; i++)
        if(!(n % i)) return 0;
    
    return 1;
}

int solution(int n, int k)
{
    int ans = 0;
    size_t num = 0;
    
    int idx = convert(n, k);
    
    for(int i = idx - 1; i >= 0; i--)
    {
        if(arr[i])
            num = (num * 10) + arr[i];
        
        if(!arr[i] || !i) //마지막에 0으로 끝나지 않을 때도 체크해야 함
        {
            ans += is_prime(num);
            num = 0;
        }
    }
    
    return ans;
}