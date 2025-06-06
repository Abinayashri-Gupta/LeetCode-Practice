class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set=new HashSet<>();
        Set<Integer> ans=new HashSet<>();
        
        for(int num:nums1)
        {
            set.add(num);
        }
        for(int num:nums2)
        {
            if(set.contains(num)) ans.add(num);
        }
        int[] res=new int[ans.size()];
        int i=0;
        for(int num:ans)
        {
            res[i++]=num;
            
        }
        return res;
    }
}