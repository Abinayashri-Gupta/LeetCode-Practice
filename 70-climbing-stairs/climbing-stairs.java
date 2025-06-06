class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        else
        {
            int a=1,b=2,result=0;
            for(int i=3;i<=n;i++)
            {
                result=a+b;
                a=b;
                b=result;

            }return result;
        }
    }
}