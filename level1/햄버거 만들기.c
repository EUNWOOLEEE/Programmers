#include <stdio.h>

int c, ans = 0;

int check(int ing[], int ing_len, int idx)
{   
    int cnt = 0;
    int burger[4] = {0,};
    
    for(int i = idx; i < ing_len; i++)
    {
        if(ing[i] == 1)
        {
            if(!cnt)
            {
                cnt++;
                burger[0] = i;
            }
            else if(cnt == 3)
            {
                ans++;
                burger[3] = i;
                for(int i = 0; i < 4; i++)
                {
                    ing[burger[i]] = 0;
                    burger[i] = 0;
                }
                return cnt;
            }
            else
            {
                c = check(ing, ing_len, i);
                if(c != 3)
                    return cnt;
            }
        }
        else if(ing[i] == 2 && cnt == 1)
        {
            cnt++;
            burger[1] = i;
        }
        else if(ing[i] == 3 && cnt == 2)
        {
            cnt++;
            burger[2] = i;
        }
        else if(!ing[i]);
        else
            return cnt;
    }
}

int solution(int ing[], size_t ing_len)
{
    for(int i = 0; i < ing_len; i++)
        if(ing[i] == 1)
            check(ing, ing_len, i);
    
    if(!ans)
        printf("상수가 포장할 수 있는 햄버거가 없습니다.");
    else
        printf("%d\n", ans);
    return ans;
}