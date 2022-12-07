#include <stdio.h>

double solution(int arr[], size_t arr_len)
{
    double ans;
    
    for(size_t i = 0; i < arr_len; i++)
        ans += arr[i];
    
    return ans / arr_len;
}