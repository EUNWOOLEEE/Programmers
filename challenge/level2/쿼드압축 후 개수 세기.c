#include <stdio.h>

//분할정복 알고리즘
int ans[2];

//구역 안의 값이 모두 같은지 확인하는 함수
int check(int row, int col, int size, int **arr)
{
    int start = arr[row][col];
    
    for(int i = row; i < size + row; i++)
        for(int j = col; j < size + col; j++)
            if(start != arr[i][j])
                return 0;
    return 1;
}

//구역을 분할하는 함수
void divide(int row, int col, int size, int **arr)
{
    if(check(row, col, size, arr))
        ans[arr[row][col]]++;
    
    else
    {
        size /= 2;
        
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                divide(row + size * i, col + size * j, size, arr);
    }
}

int* solution(int** arr, size_t arr_rows, size_t arr_cols)
{
    divide(0, 0, arr_rows, arr);
    
    return ans;
}