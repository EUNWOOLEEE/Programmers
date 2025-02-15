#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* phone_number)
{
    int len = strlen(phone_number);
    char* ans = (char *)malloc(sizeof(char) * (len + 1));
    
    for(int i = 0; i < len; i++)
    {
        if(len - i <= 4)
            ans[i] = phone_number[i];
        else
            ans[i] = '*';
    }
    ans[len] = '\0';
    
    return ans;
}


//-------------------------------------------------------


#include <stdio.h>
#include <string.h>

char* solution(const char* phone_number)
{
    char* ans = strdup(phone_number);
    
    for(int i = 0; i < strlen(phone_number) - 4; i++)
        ans[i] = '*';
    
    return ans;
}