class Solution {
    public int maxSubArray(int[] nums) {
        int curmax=nums[0],maxSum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            curmax=Math.max(nums[i],curmax+nums[i]);//ipo irukura element correct ah ila en kooda irukura sum ah serthu correct ah
            maxSum=Math.max(curmax,maxSum);
        }
        return maxSum;
    }
}