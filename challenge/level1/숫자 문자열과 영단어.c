#include <stdio.h>
#include <ctype.h>

int solution(const char* s)
{
    int i;
    int ans = 0;
    char num[11][6] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    while(*s)
    {
        if(isdigit(*s))
            i = *s++ - '0';
 
        else
        {
            for(i = 0; i < 10; i++)
                if(!strncmp(s, num[i], 2))
                    break ;
            s += strlen(num[i]);
        }
        
		ans = (ans * 10) + i;        
    }
    return ans;
}