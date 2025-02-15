#include <stdio.h>
#include <stdlib.h>

int cmp(const void *A, const void *B)
{
    char *a = (char *)A;
    char *b = (char *)B;

    if(*a > *b)
        return -1;
    return 1;
}

char* solution(const char* s)
{
    char* ans = strdup(s);
    
    qsort(ans, strlen(ans), sizeof(char), cmp);
    
    return ans;
}