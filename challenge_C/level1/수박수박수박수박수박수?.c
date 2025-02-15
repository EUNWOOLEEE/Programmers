#include <stdio.h>
#include <stdlib.h>

char* solution(int n)
{
    int i;
    char* ans = (char*)malloc(sizeof(char) * ((n * 3) + 1));
    
    for(i = 0; i < n * 3; i += 3)
    {
        if(i % 2)
            memcpy(&ans[i], "박", 3);
        else
            memcpy(&ans[i], "수", 3);
    }
    ans[i] = '\0';
    
    return ans;
}