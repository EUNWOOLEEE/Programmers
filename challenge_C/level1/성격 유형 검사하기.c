#include <stdio.h>
#include <stdlib.h>

int result[8] = {0,};
int score[7] = {3, 2, 1, 0, 1, 2, 3};
char c_list[9] = "RTCFJMAN";
    
int get_idx(const char c)
{
    for(int i = 0; c_list[i]; i++)
        if(c_list[i] == c)
            return i;
    return 0;
}

char* solution(const char* survey[], size_t survey_len, int choices[], size_t choices_len)
{    
    char* answer = (char*)malloc(sizeof(char) * 5);
    
    int idx;
    for(int i = 0; i < survey_len; i++)
    {
        if(choices[i] == 4) continue ;
        
        else if(choices[i] < 4)
            idx = get_idx(survey[i][0]);
        
        else
            idx = get_idx(survey[i][1]);
        
        result[idx] += score[choices[i] - 1];
    }
    
    idx = 0;
    for(int i = 0; c_list[i]; i += 2)
    {
        if(result[i] < result[i + 1])
            answer[idx++] = c_list[i + 1];
        
        else
            answer[idx++] = c_list[i];
    }

    answer[idx] = '\0';
    return answer;
}