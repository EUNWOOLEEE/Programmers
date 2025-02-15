#include <stdio.h>

#define index(col, x, y) col * x + y //인덱스 구하는 식

int arr[100 * 100] = {0,};

void init(int row, int col)
{
	for(int i = 0; i < row * col; i++)
		arr[i] = i + 1;
}

int rotate(int x1, int y1, int x2, int y2, int col)
{
	int min = 10000;
	int num = arr[index(col, (x1 + 1), y1)]; //회전 시 맨 마지막 숫자 저장 (시작 지점 바로 아래)
	
	//x고정 y증가 →
	for(int y = y1; y <= y2; y++)
	{
		if(num < min) min = num;
		
		int tmp = arr[index(col, x1, y)];
		arr[index(col, x1, y)] = num;
		num = tmp;
	}
	
	//y고정 x증가 ↓
	for(int x = x1 + 1; x <= x2; x++)
	{
		if(num < min) min = num;
		
		int tmp = arr[index(col, x, y2)];
		arr[index(col, x, y2)] = num;
		num = tmp;
	}
	
	//x고정 y감소 ←
	for(int y = y2 - 1; y >= y1; y--)
	{
		if(num < min) min = num;
		
		int tmp = arr[index(col, x2, y)];
		arr[index(col, x2, y)] = num;
		num = tmp;
	}
	
	//y고정 x감소 ↑
	for(int x = x2 - 1; x > x1; x--)
	{
		if(num < min) min = num;
		
		int tmp = arr[index(col, x, y1)];
		arr[index(col, x, y1)] = num;
		num = tmp;
	}
	
	return min;
}
    
int* solution(int rows, int columns, int **queries, size_t queries_row_len, size_t queries_col_len)
{
	int *ans = (int*)malloc(sizeof(int) * queries_row_len);
	init(rows, columns);
	
	for(int i = 0; i < queries_row_len; i++)
		ans[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1, columns);
		
	return ans;
}