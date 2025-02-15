#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef long long ll;

ll get_fx(ll num)
{
    int idx = 0, zero = 0;
    char str[51] = {0,}; //제한 max값의 비트가 50자리
    
    for(; num; num /= 2)
    {
        int remain = num % 2;
        
        //0번째 인덱스 값이 0이면 num + 1 리턴
        if(!idx && !remain)
            return num + 1;
            
        //zero에 0이 처음 나온 위치 기록
        if(!zero && !remain)
            zero = idx;
        str[idx++] = num % 2 + '0';
    }
    
    //1만 있을 때 -> 맨 뒤를 0으로 바꾸고 그 뒤에 1을 붙임
    if(!zero)
    {
        str[idx - 1] = '0';
        str[idx++] = '1';
    }
    
    //가장 먼저 나온 0을 1로, 바로 앞 비트를 0으로 바꿈
    else
    {
        str[zero] = '1';
        str[zero - 1] = '0';
    }
    
    ll res = 0;
    for(int i = 0; i < idx; i++)
        res += (str[i] - '0') * pow(2, i);
        
    return res;
}

ll* solution(ll numbers[], size_t numbers_len)
{
    ll* ans = (ll*)calloc(numbers_len, sizeof(ll));
    
    for(int i = 0; i < numbers_len; i++)
        ans[i] = get_fx(numbers[i]);
        
    return ans;
}