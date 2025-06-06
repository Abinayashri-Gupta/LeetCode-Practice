class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        boolean up=true;
        int m=mat.length,n=mat[0].length;
        int i=0;
        int[] ans=new int[m*n];
        int row=0,col=0;
        while(row<m && col<n)
        {
            if(up)
            {
                while(row>0 && col<n-1)
                {
                    ans[i++]=mat[row][col];
                    row--;
                    col++;
                }
                ans[i++]=mat[row][col];
                if(col==n-1){row++;}
                else {col++;}

            }
            else
            {
                while(row<m-1 && col>0)
                {
                    ans[i++]=mat[row][col];
                    row++;
                    col--;
                }
                ans[i++]=mat[row][col];
                if(row==m-1){col++;}
                else{row++;}
            }
            up=!up;
        }
        return ans;
    }
}