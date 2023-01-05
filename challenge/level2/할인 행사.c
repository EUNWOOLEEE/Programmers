#include <stdio.h>
#include <string.h>

//일치하는 품목 인덱스 찾기
int get_item_idx(const char **want, const char *item, int want_len)
{
	for(int i = 0; i < want_len; i++)
		if(!strcmp(item, want[i]))
			return i;
	return -1;
}

//특정 날짜부터 10일동안 배열에 일치하는 품목 값 빼기
void search_item(int *arr, const char **dis, const char **want, int want_len)
{
	for(int i = 0; i < 10; i++)
	{
		int idx = get_item_idx(want, dis[i], want_len);
		if(idx >= 0)
			arr[idx]--;
	}
}

//배열에 0만 있는지 확인
int check_arr(int *arr, int number_len)
{
	for(int i = 0; i < number_len; i++)
		if(arr[i])
			return 0;
	return 1;
}

int solution(const char* want[], size_t want_len, int number[], size_t number_len, const char* discount[], size_t discount_len)
{
	int arr[10] = {0,};
	int ans = 0;
	
	for(int i = 0; i <= discount_len - 10; i++)
	{
		memcpy(arr, number, sizeof(int) * number_len);
		search_item(arr, &discount[i], want, want_len);
		ans += check_arr(arr, number_len);
	}
	return ans;
}