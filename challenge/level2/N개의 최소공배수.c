#include <stdio.h>

int get_gcd(int a, int b) //최대공약수
{
    while(b)
    {
        int tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
}

int get_lcm(int a, int b, int gcd) //최고공배수
{
    return (a * b / gcd);
}

int solution(int arr[], size_t arr_len)
{
    int gcd = arr[0];
    int lcm = arr[0];
    
    for(int i = 1; i < arr_len; i++)
    {
        gcd = get_gcd(lcm, arr[i]);
        lcm = get_lcm(lcm, arr[i], gcd);
    }
    
    return lcm;
}