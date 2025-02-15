#include <stdio.h>
#include <string.h>

typedef struct
{
    int cnt; //탐색 횟수
    int rest; //잔여 피로도
    int visited[8];
} dungeon;

int ans = 0;
int front, rear;
dungeon cur, next;
dungeon queue[100000] = {0,};

void bfs(int **dungeons, int rows, int idx, int rest)
{
    cur.visited[idx]++;
    cur.cnt = 1;
    cur.rest = rest - dungeons[idx][1];
    
    queue[rear++] = cur;
    
    while(front < rear)
    {
        cur = queue[front++];
        
        for(int i = 0; i < rows; i++)
        {
            if(!cur.visited[i] && cur.rest >= dungeons[i][0]) //방문한 적 없고 잔여 피로도가 필요 피로도 이상이면
            {
                memcpy(next.visited, cur.visited, sizeof(int) * 8);
                next.visited[i]++;
                next.cnt = cur.cnt + 1;
                next.rest = cur.rest - dungeons[i][1];
                
                if(next.rest > 0)
                    queue[rear++] = next;
                
                ans = ans < next.cnt ? next.cnt : ans;
            }
        }
    }
}

int solution(int k, int** dungeons, size_t dungeons_rows, size_t dungeons_cols)
{
    for(int i = 0; i < dungeons_rows; i++)
    {
		//해당 던전의 필요 피로도가 k 미만이면 bfs 시작
        if(k >= dungeons[i][0])
        {
            memset(&cur, 0, sizeof(dungeon)); //cur의 visited를 초기화 해줘야 함
            front = rear = 0;
            bfs(dungeons, dungeons_rows, i, k);
        }
    }
    return ans;
}