#include <stdio.h>
#include <stdbool.h>

bool solution(int x)
{
    int tmp = 0;
    
    for(int n = x; n; n /= 10)
        tmp += n % 10;
    
    return x % tmp ? false : true;
}