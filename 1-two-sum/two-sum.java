class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int micham=target-nums[i];
            if(map.containsKey(micham))
            {
                return new int[]{map.get(micham),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}