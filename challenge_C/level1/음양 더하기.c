#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int absolutes[], size_t absolutes_len, bool signs[], size_t signs_len)
{
    int ans = 0;
    
    for(int i = 0; i < signs_len; i++)
    {
        if(signs[i] == false)
            absolutes[i] *= -1;
        ans += absolutes[i];
    }
        
    return ans;
}