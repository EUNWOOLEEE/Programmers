#include <stdio.h>
#include <string.h>

int ans, cnt;
char dic[6] = "AEIOU";
char res[6] = {0,};

void rec(int depth, const char *word)
{
	if(!strcmp(word, res))
	{
		ans = cnt;
		return ;
	}

	if(depth > 4)
		return ;
    
	for(int i = 0; i < 5; i++)
	{
		cnt++;
		strncat(res, &dic[i], 1);
		rec(depth + 1, word);
		res[depth] = 0;
	}
}

int solution(const char* word)
{
    rec(0, word);
    return ans;
}