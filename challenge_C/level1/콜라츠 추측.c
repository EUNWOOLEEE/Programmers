#include <stdio.h>

int solution(int num)
{
    int ans;
	long n = (long)num;
    
    for(ans = 0; n != 1; ans++)
    {
        if(!(n % 2))
            n /= 2;

        else
            n = n * 3 + 1;
        
        if(ans == 500)
            return -1;
    }
    
    return ans;
}