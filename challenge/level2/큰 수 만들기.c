#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* number, int k)
{
	char *str = strdup(number);
	char *ans = calloc(strlen(number) - k + 1, sizeof(char));

	for(int i = 0; str[i]; i++)
	{
        //k개만큼 숫자가 남아있을 경우
		if(strlen(str) - i == k)
		{
			str[i] = -1;
			k--;
			continue;
		}

        //i부터 남은 k개 범위 안에 i보다 더 큰 수가 있으면 i를 -1로 초기화
		for(int j = i + 1; j <= i + k; j++)
		{
			if(str[i] < str[j])
			{
				str[i] = -1;
				k--;
				break;
			}
		}
		
		if(!k) break;
	}
	
	for(int idx = 0, i = 0; str[i]; i++)
		if(str[i] != -1)
			ans[idx++] = str[i];

	return ans;
}