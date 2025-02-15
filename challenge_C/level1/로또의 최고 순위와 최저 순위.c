#include <stdio.h>
#include <stdlib.h>

int* solution(int lottos[], size_t lottos_len, int win_nums[], size_t win_nums_len)
{    
    int zero = 0, win = 0;
    for(int i = 0; i < 6; i++)
    {
        if(!lottos[i])
            zero++;

        else
            for(int j = 0; j < 6; j++)
                if(lottos[i] == win_nums[j])
                    win++;
    }
    
    int* ans = (int*)malloc(sizeof(int) * 2);
    int ranking[7] = {6, 6, 5, 4, 3, 2, 1};
    
    ans[0] = ranking[zero + win];
    ans[1] = ranking[win];

    return ans;
}