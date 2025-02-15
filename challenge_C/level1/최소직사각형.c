#include <stdio.h>

int solution(int** sizes, size_t r_size, size_t c_size)
{
    int w = 0, h = 0;
    
    for(int i = 0; i < r_size; i++)
    {
        if(sizes[i][0] > sizes[i][1])
        {
            w = sizes[i][0] > w ? sizes[i][0] : w;
            h = sizes[i][1] > h ? sizes[i][1] : h;
        }
        else
        {
            w = sizes[i][1] > w ? sizes[i][1] : w;
            h = sizes[i][0] > h ? sizes[i][0] : h;
        }
    }
    return w * h;
}