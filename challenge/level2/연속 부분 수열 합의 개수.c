#include <stdio.h>

#define MAX 500000

int solution(int elements[], size_t elements_len)
{
	int sum;
	int i = 0;
	int cnt = 1;
	int arr[MAX] = {0,};

	while(i < elements_len)
	{
		sum = 0;
		for(int j = i; j < i + cnt; j++)
		{
			if(j >= elements_len)
				sum += elements[j % elements_len];
			else
				sum += elements[j];
		}

		arr[sum]++;
		cnt++;

		if(cnt == elements_len + 1)
		{
			i++;
			cnt = 1;
		}
	}

	int ans = 0;
	for(i = 0; i < MAX; i++)
		if(arr[i]) ans++;

	return ans;
}