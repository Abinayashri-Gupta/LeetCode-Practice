/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
         int[] max=new int[]{Integer.MIN_VALUE};
         dfs(root,max);
         return max[0];
    }
    private int dfs(TreeNode node,int[] max) {
        if(node==null) return 0;
        int left=Math.max(0,dfs(node.left,max));
        int right=Math.max(0,dfs(node.right,max));
        max[0]=Math.max(max[0],left+right+node.val);
        return node.val+Math.max(left,right);
    }
}