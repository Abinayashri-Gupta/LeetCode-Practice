/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> ans=new ArrayList<>();
        ListNode current=head;
        while(current!=null)
        {
            ans.add(current.val);
            current=current.next;
        }
        int low=0,high=ans.size()-1;
        while(low<=high)
        {
            if(ans.get(low)!=ans.get(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}