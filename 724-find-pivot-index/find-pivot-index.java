class Solution {
    public int pivotIndex(int[] nums) {
        int[] rightsum=new int[nums.length];
        rightsum[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            rightsum[i]=rightsum[i+1]+nums[i+1];
        }

        int leftsum=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(leftsum==rightsum[i])
            {
                return i;
            }
            leftsum+=nums[i];
        }
        return -1;
    }
}