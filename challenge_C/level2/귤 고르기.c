#include <stdio.h>
#include <stdlib.h>

int cmp(const void *A, const void *B)
{
    int a = *(int *)A;
    int b = *(int *)B;
    
    if(a > b) return -1;
    return 1;
}

int solution(int k, int tangerine[], size_t tangerine_len)
{
    int max = 0;
    int arr[10000001] = {0,};
    for(int i = 0; i < tangerine_len; i++)
    {
        arr[tangerine[i]]++;
        max = max > tangerine[i] ? max : tangerine[i];
    }
    
    qsort(arr, max + 1, sizeof(int), cmp);
    
    int in_box = 0;
    for(int i = 0; i < max; i++) //max번째에는 처음 0번째 인덱스 == 0이 와있음
    {
        in_box += arr[i];
        if(in_box >= k)
            return i + 1;
    }
    
    return 0;
}