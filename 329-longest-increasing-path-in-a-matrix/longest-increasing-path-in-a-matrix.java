class Solution {
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        int[][] dp=new int[m][n];
        int max=0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                max=Math.max(max, dfs(matrix, i, j, dp));
                }
            }
        return max;
        }
    private int dfs(int[][] matrix,int i,int j,int[][] dp) {
        if(dp[i][j]!=0) return dp[i][j]; 
        int max=1;
        for (int[] d: dirs) {
            int x=i+d[0],y=j+d[1];
            if (x>=0 && x<m && y>=0 && y<n && matrix[x][y]>matrix[i][j]) {
                max=Math.max(max,1+dfs(matrix,x,y,dp));
            }
        }
        return dp[i][j] = max;
    }
}