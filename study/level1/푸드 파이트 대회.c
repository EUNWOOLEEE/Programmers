#include <stdio.h>
#include <stdlib.h>

char* solution(int food[], size_t food_len)
{
    int len = 1;
    
    for(int i = 1; i < food_len; i++)
    {
        if(food[i] % 2)
            food[i]--;
        
        len += food[i];
    }
    
    char* ans = (char*)malloc(sizeof(char) * (len + 1));
    
    int i, idx = 0;
    for(i = 1; i < food_len; i++)
    {
        for(int j = 0; j < food[i] / 2; j++)
            ans[idx++] = i + '0';
        food[i] /= 2;
    }
    
    ans[idx++] = '0';
    i--;
    for(; i > 0; i--)
    {
        for(int j = 0; j < food[i]; j++)
            ans[idx++] = i + '0';
    }
    
    ans[idx] = '\0';
    return ans;
}