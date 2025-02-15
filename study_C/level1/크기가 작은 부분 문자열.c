#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int solution(const char* t, const char* p)
{
    int ans = 0;    
    int len = strlen(p);
    long long num = strtoll(p, (char**)NULL, 10);
    char *tmp = (char *)calloc(len + 1, sizeof(char));
    
    for(int i = 0; i <= strlen(t) - len; i++)
    {
        memcpy(tmp, &t[i], len);
        if(strtoll(tmp, (char**)NULL, 10) <= num)
            ans++;
    }
    
    return ans;
}