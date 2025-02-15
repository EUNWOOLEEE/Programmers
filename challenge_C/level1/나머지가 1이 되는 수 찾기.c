int solution(int n)
{
    int ans;
    for(ans = 1; ans < n; ans++)
    {
        if((n % ans) == 1)
            return ans;
    }
    return ans;
}