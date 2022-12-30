#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int from_dir[4]; //해당 좌표에서 간 방향 기록
	int to_dir[4]; //해당 좌표로 온 방향 기록
} direction;

int x, y;
int x_dir[4] = {0, 0, 1, -1};
int y_dir[4] = {1, -1, 0, 0};
direction visited[11][11]; //x, y 값에 +5한 좌표에 방문기록


int get_cmd(char c)
{
    char cmd[5] = "UDRL";
    
    for(int i = 0; i < 4; i++)
        if(cmd[i] == c) return i;
}

int valid_coor(char cmd)
{
    if(x < -5 || y < -5 || x > 5 || y > 5)
        return 0;

    if(visited[x + 5][y + 5].to_dir[cmd]) //같은 방향에서 해당 좌표로 온 적 있는지
		return -1;
	
	if(cmd == 0 || cmd == 2) cmd++; //cmd 반대방향으로 초기화
		else cmd--;

	if(visited[x + 5][y + 5].from_dir[cmd]) //해당 좌표로 온 방향으로 간 적 있는지
		return -1;
    
    return 1;
}

int solution(const char* dirs)
{
    int cmd, ans = 0;
	int pre_x, pre_y;

    for(; *dirs; dirs++)
    {
        pre_x = x;
        pre_y = y;
        cmd = get_cmd(*dirs);
        
        x += x_dir[cmd];
        y += y_dir[cmd];
        
        if(valid_coor(cmd) == 1)
        {
			visited[pre_x + 5][pre_y + 5].from_dir[cmd] += x_dir[cmd]; //간 방향 체크
			visited[pre_x + 5][pre_y + 5].from_dir[cmd] += y_dir[cmd];
            visited[x + 5][y + 5].to_dir[cmd] += x_dir[cmd]; //온 방향 체크
            visited[x + 5][y + 5].to_dir[cmd] += y_dir[cmd];
            ans++;
        }
        
        else if(!valid_coor(cmd))
        {
            x = pre_x;
            y = pre_y;
        }

	    //-1이면 이미 간 길이라 이동하기만 함
    }
    
    return ans;
}