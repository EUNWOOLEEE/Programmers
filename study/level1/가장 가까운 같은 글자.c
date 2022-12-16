#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* solution(const char* s)
{
    int *ans = (int *)malloc(sizeof(int) * strlen(s));
    int arr[123];
    
    memset(arr, -1, sizeof(int) * 123);
    
    for(int i = 0; s[i]; i++)
    {
        if(arr[s[i]] == -1)
            ans[i] = -1;
        else
            ans[i] = i - arr[s[i]];

        arr[s[i]] = i;
    }
    
    return ans;
}