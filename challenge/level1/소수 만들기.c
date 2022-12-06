#include <stdio.h>

int is_prime(int num)
{
    for(int i = 2; i * i <= num; i++)
        if(!(num % i))
            return 0;

    return 1;
}

int solution(int nums[], size_t nums_len)
{
    int ans = 0;
    
    for(size_t i = 0; i < nums_len; i++)
        for(size_t j = i + 1; j < nums_len; j++)
            for(size_t k = j + 1; k < nums_len; k++)
                if(is_prime(nums[i] + nums[j] + nums[k]))
                    ans++;
    
    return ans;
}