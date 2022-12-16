#include <stdio.h>
#include <stdlib.h>

int solution(const char* s)
{
    char c = s[0];
    int ans, cnt_x, cnt_y;
    ans = cnt_x = cnt_y = 0;

    for(int i = 0; s[i]; i++)
    {
        if(s[i] == c)
            cnt_x++;
        else
            cnt_y++;
                
        if(cnt_x == cnt_y)
        {
            cnt_x = cnt_y = 0;
            c = s[i + 1];
            ans++;
        }
    }
    
    if(cnt_x || cnt_y)
        ans++;
    
    return ans;
}