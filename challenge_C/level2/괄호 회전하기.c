#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int top;
char stack[1000];

void push(char c)
{
    stack[top++] = c;
}

int pop()
{
    return (stack[--top]);
}

int check(char *str)
{
    for(int i = 0; str[i]; i++)
    {
        //왼쪽 괄호
        if(str[i] == '(') push('(');
        else if(str[i] == '{') push('{');
        else if(str[i] == '[') push('[');
        
        //오른쪽 괄호
        else
        {
            if(!top) //stack이 비어있으면
                return 0;
            
            char tmp = pop();
            
            if((tmp == '(' && str[i] != ')') ||
               (tmp == '{' && str[i] != '}') ||
                (tmp == '[' && str[i] != ']'))
                return 0;
        }
    }
    if(top)
        return 0;
    return 1;
}

int solution(const char* s)
{
    int ans = 0;
    int len = strlen(s);
    char *str = strdup(s);
    
    for(int i = 0; i < len; i++)
    {
        top = 0;
        if(check(str)) ans++;
        
        char tmp = str[0];
        memcpy(str, &str[1], len - 1);
        str[len - 1] = tmp;
    }
    
    return ans;
}