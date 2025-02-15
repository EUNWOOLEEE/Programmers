#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 3000000

char* solution(const char* X, const char* Y)
{
    char *ans = (char *)malloc(sizeof(char) * MAX);
    int x_arr[10] = {0,};
    int y_arr[10] = {0,};
    
    for(int i = 0; X[i]; i++)
        x_arr[X[i] - '0']++;

    for(int i = 0; Y[i]; i++)
        y_arr[Y[i] - '0']++;
    
    int idx = 0;
    for(int i = 9; i >= 0; i--)
    {
        if(x_arr[i] > y_arr[i])
            for(int j = 0; j < y_arr[i]; j++)
                ans[idx++] = i + '0';
        
        else
            for(int j = 0; j < x_arr[i]; j++)
                ans[idx++] = i + '0';
    }
    
    if(!idx)
    {
        ans[0] = '-';
        ans[1] = '1';
        return ans;
    }
    
    if(ans[0] == '0')
    {
        ans[1] = '\0';
        return ans;
    }
        
    ans[idx] = '\0';
    
    return ans;
}