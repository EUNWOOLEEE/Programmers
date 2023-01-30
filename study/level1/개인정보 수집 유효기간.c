#include <stdio.h>
#include <stdlib.h>

int* solution(const char* today, const char* terms[], size_t terms_len, const char* pri[], size_t pri_len)
{
	int iterms[26] = {0,};
	int today_total = (atoi(today) * 336) + (atoi(&today[5]) * 28) + atoi(&today[8]);
	int y, m, d, idx = 0;
	int *ans = (int *)calloc(pri_len, sizeof(int));
	
	// [약관 종류 -'A'] idx에 해당 유효기간 저장
	for(size_t i = 0; i < terms_len; i++)
		iterms[terms[i][0] - 'A'] = atoi(&terms[i][2]);
		
	for(size_t i = 0; i < pri_len; i++)
	{
		y = atoi(pri[i]) * 336;
		m = (atoi(&pri[i][5]) + iterms[pri[i][11] - 'A']) * 28;
		d = atoi(&pri[i][8]);
		
		if(y + m + d <= today_total)
			ans[idx++] = i + 1;
	}
	
	return ans;
}


// ----------------------------------------------------------------------------------------------------------


#include <stdio.h>
#include <stdlib.h>

int* solution(const char* today, const char* terms[], size_t terms_len, const char* pri[], size_t pri_len)
{
	int iterms[26] = {0,};
	int today_y = atoi(today);
	int today_m = atoi(&today[5]);
	int today_d = atoi(&today[8]);
	int y, m, d, idx = 0;
	int *ans = (int *)calloc(pri_len, sizeof(int));
	
	// [약관 종류 -'A'] idx에 해당 유효기간 저장
	for(size_t i = 0; i < terms_len; i++)
		iterms[terms[i][0] - 'A'] = atoi(&terms[i][2]);
		
	for(size_t i = 0; i < pri_len; i++)
	{
		y = atoi(pri[i]);
		m = atoi(&pri[i][5]) + iterms[pri[i][11] - 'A'];
		d = atoi(&pri[i][8]);
		
		// 2022.12.01 + 12달 = 2023.12.01
		if(!(m % 12))
		{
			y += m / 12 - 1;
			m = 12;
		}
		else if(m > 12)
		{
			y += m / 12;
			m %= 12;
		}
		
		if(y < today_y)
			ans[idx++] = i + 1;
		else if(y == today_y)
		{
			if(m < today_m)
				ans[idx++] = i + 1;
			else if(m == today_m)
			{
				if(d <= today_d)
					ans[idx++] = i + 1;
			}
		}
	}
	
	return ans;
}