#include <stdio.h>
#include <stdlib.h>

int solution(const char* s)
{
    return atoi(s);
}



//-----------------------------------------



#include <stdio.h>
#include <ctype.h>

int solution(const char* s)
{
    int ans = 0, i = 0;
    
    if(s[i] == '+' || s[i] == '-')
        i++;
    
    while(isdigit(s[i]))
        ans = (ans * 10) + (s[i++] - '0');
    
    return *s == '-' ? -ans : ans;
}