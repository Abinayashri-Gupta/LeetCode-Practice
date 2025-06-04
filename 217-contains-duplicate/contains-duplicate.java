class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int flag=1;
        for(int num:nums)
        {
            if(!set.contains(num))
                set.add(num);
            else{
                flag=0;
                break;
            }
        }
        boolean ans=(flag==1) ? false : true;
        return ans;

    }
}