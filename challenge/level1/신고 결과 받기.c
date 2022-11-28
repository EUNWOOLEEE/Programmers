#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000
#define MAX_ID 20

int* solution(const char* id_list[], size_t id_list_len, const char* report[], size_t report_len, int k)
{    
    char from[MAX_ID], to[MAX_ID];
    int from_num, to_num;
    int cnt[MAX] = {0,}; //내가 신고 당한 횟수
    int list[MAX][MAX] = {0,}; //내가 신고한 사람 목록
    int* ans = (int*)malloc(sizeof(int) * id_list_len);

    memset(ans, 0, sizeof(int) * id_list_len);

    for(size_t i = 0; i < report_len; i++)
    {
        memset(from, 0, MAX_ID);
        memset(to, 0, MAX_ID);

        size_t j, l;
        for(j = 0; report[i][j] != ' '; j++)
            from[j] = report[i][j];
        from[j] = '\0';

        j++;

        for(l = 0; report[i][l + j]; l++)
            to[l] = report[i][l + j];
        to[l + j] = '\0';

        for(j = 0; j < id_list_len; j++)
            if(!strcmp(id_list[j], from))
                from_num = j;

        for(j = 0; j < id_list_len; j++)
            if(!strcmp(id_list[j], to))
                to_num = j;

        if(!list[from_num][to_num])
        {
            list[from_num][to_num]++;
            cnt[to_num]++;
        }
    }

    for(size_t i = 0; i < id_list_len; i++)
    {
        if(cnt[i] >= k)
            for(size_t j = 0; j < id_list_len; j++)
                if(list[j][i])
                    ans[j] += 1;
    }

    return ans;
}