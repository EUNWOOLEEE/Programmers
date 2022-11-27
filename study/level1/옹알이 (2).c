#include <stdio.h>
#include <string.h>

char type[4][4] = {"aya", "ye", "woo", "ma"};

int check(const char *bab)
{
    int tmp = 4;

    int i;
    while(*bab)
    {
        for(i = 0; i < 4; i++)
        {
            if(!strncmp(bab, type[i], strlen(type[i])) && tmp != i)
            {
                tmp = i;
                bab += strlen(type[i]);
                break ;
            }
        }
        if (i == 4)
            return 1;
    }
    return 0;
}

int solution(const char* babbling[], size_t babbling_len)
{
    int ans = 0;
    
    for(int i = 0; i < babbling_len; i++)
        if(!check(babbling[i]))
            ans++;
    
    return ans;
}