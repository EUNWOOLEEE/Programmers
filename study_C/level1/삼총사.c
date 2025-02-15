#include <stdio.h>

int solution(int num[], size_t num_len)
{
    int ans = 0;

    for(int i = 0; i < num_len; i++)
        for(int j = i + 1; j < num_len; j++)
            for(int k = j + 1; k < num_len; k++)
                if(!(num[i] + num[j] + num[k]))
                    ans++;
    
    return ans;
}