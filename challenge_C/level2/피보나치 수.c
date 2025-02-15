#include <stdio.h>

int solution(int n)
{
    int first = 1, second = 1;
    
    for(int i = 2; i < n; i++)
    {
        int tmp = first;
        first = (first + second) % 1234567;
        second = tmp % 1234567;
    }
    
    return first;
}