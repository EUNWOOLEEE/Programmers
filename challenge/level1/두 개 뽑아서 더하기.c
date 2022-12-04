#include <stdio.h>
#include <stdlib.h>

int* solution(int numbers[], size_t numbers_len)
{
    int size = 0;
    int arr[201] = {0,};
    
    for(int i = 0; i < numbers_len; i++)
        for(int j = i + 1; j < numbers_len; j++)
            if(!arr[numbers[i] + numbers[j]])
            {
                arr[numbers[i] + numbers[j]]++;
                size++;
            }
    
    
    int idx = 0;
    int *ans = (int *)malloc(sizeof(int) * size);
    
    for(int i = 0; i <= 200; i++)
        if(arr[i])
            ans[idx++] = i;
    
    return ans;
}