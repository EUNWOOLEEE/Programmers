#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* solution(const char* s)
{
    int idx = 0;
    char* ans = strdup(s);
    
    for(int i = 0; ans[i]; i++)
    {
        if(ans[i] == ' ')
        {
            idx = 0;
            continue;
        }
        if(!(idx % 2))
            ans[i] = toupper(ans[i]);
        else
            ans[i] = tolower(ans[i]);
        idx++;
    }
    return ans;
}