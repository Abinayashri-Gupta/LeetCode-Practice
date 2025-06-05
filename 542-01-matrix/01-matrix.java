class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] result=new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                result[i][j]=100000;
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]==0) result[i][j]=0;
                else
                {
                    if(j>0){
                        result[i][j]=Math.min(result[i][j],result[i][j-1]+1);
                    }
                    if(i>0){
                        result[i][j]=Math.min(result[i][j],result[i-1][j]+1);
                    }
                }
            }
        }

         for(int i=row-1;i>=0;i--)
        {
            for(int j=col-1;j>=0;j--)
            {
                if(matrix[i][j]==0) result[i][j]=0;
                else
                {
                    if(i<row-1){
                        result[i][j]=Math.min(result[i][j],result[i+1][j]+1);
                    }
                    if(j<col-1){
                        result[i][j]=Math.min(result[i][j],result[i][j+1]+1);
                    }
                }
            }
        }
        return result;
    }
}