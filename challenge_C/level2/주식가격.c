#include <stdio.h>
#include <stdlib.h>

int* solution(int prices[], size_t prices_len)
{
    int* ans = (int*)malloc(sizeof(int) * prices_len);
    
    int i, j;
    for(i = 0; i < prices_len; i++)
    {
        for(j = i + 1; j < prices_len; j++)
            if(prices[i] > prices[j])
            {
                ans[i] = j - i;
                break;
            }

        if(j == prices_len)
            ans[i] = j - i - 1;
    }
    return ans;
}


//-----------------------------------------------------------


#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int num; //값
    int idx; //초기 인덱스
} value;

int top = -1;
value stack[100000];

void push(int n, int idx)
{
    stack[++top].num = n;
    stack[top].idx = idx;
}

value pop()
{
    return stack[top--];
}

int* solution(int prices[], size_t prices_len)
{
    value tmp;
    int* ans = (int*)malloc(sizeof(int) * prices_len);
    
    push(prices[0], 0);
    for(int i = 1; i < prices_len; i++)
    {
        // stack의 맨 위에서부터 새 값과 비교
        for(int j = top; j >= 0; j--)
        {
            // 가격이 떨어졌으면 stack에서 해당 구조체를 pop하고,
            // (현재 값의 인덱스 - 초기 인덱스) 값을 ans[초기 인덱스]에 저장
            if(stack[top].num > prices[i])
            {
                tmp = pop();
                ans[tmp.idx] = i - tmp.idx;
            }
        }
        push(prices[i], i);
    }

    // 아직 stack에 남아있는 값은 (값의 개수 - 초기 인덱스 - 1) 값을 ans[초기 인덱스]에 저장
	for(int i = 0; i <= top; i++)
		ans[stack[i].idx] = prices_len - stack[i].idx - 1;
    
    return ans;
}