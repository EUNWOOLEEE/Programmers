#include <stdio.h>
#include <stdbool.h>

bool solution(const char* s)
{
    int left = 0, right = 0;
    
    for(int i = 0; s[i]; i++)
    {
        if(left < right)
            return false;
        
        if(s[i] == '(') left++;
        
        else right++;
    }
    
    if(left != right)
        return false;    
    return true;
}