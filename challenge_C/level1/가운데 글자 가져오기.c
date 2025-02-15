#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* s)
{
    int size = 2;
    int idx = strlen(s) / 2;
    
    if(!(strlen(s) % 2)) idx--;
    else size--;

    char* ans = (char*)malloc(size + 1);

    strncpy(ans, &s[idx], size);
    ans[size] = '\0';

    return ans;
}