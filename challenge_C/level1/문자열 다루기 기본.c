#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

bool solution(const char* s)
{
    if(strlen(s) != 4 && strlen(s) != 6)
        return false;
    
    for(int i = 0; s[i]; i++)
        if(!isdigit(s[i]))
            return false;
    
    return true;
}