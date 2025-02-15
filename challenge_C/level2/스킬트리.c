#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ans = 0;
int arr[26] = {0,};

void check_tree(int len) //순서가 바른지 확인
{
    int pre = 0;
    
    for(int i = 0; i < len; i++)
    {
        int cur = arr[i];
        if(!cur) //0이 나오면 뒤로 쭉 0인지 확인
        {
            for(int j = i + 1; j < len; j++)
                if(arr[j])
                    return ;
            break;
        }
        if(pre > cur) //뒤 스킬이 먼저 나왔을 때
            return ;
        pre = cur;
    }
    ans++;
}

int get_num(char *skill, char c)
{
    for(int i = 0; skill[i]; i++)
        if(skill[i] == c)
            return i;
    return -1;
}

void set_tree(char *skill, char *tree) //스킬이 나온 순서 기록
{
    int cnt = 1;
    for(int i = 0; tree[i]; i++)
    {
        int idx = get_num(skill, tree[i]);
        if(idx >= 0)
            arr[idx] = cnt++;
    }
}

int solution(const char* skill, const char* skill_trees[], size_t skill_trees_len)
{
    for(int i = 0; i < skill_trees_len; i++)
    {
        memset(arr, 0, sizeof(int) * 26);
        set_tree(skill, skill_trees[i]);
        check_tree(strlen(skill));
    }
    return ans;
}