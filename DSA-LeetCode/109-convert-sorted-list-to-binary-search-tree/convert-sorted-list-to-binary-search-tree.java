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
    public ListNode mid(ListNode head){
        if(head==null)return null;
        ListNode s=head;
        ListNode f=head.next;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }return s;
    }

    public TreeNode build(ListNode head){
        if(head==null)return null;
        if(head.val==Integer.MAX_VALUE)return null;

        ListNode mid=mid(head);
        TreeNode curr=new TreeNode(mid.val);
        curr.right=build(mid.next);
        mid.next=null;
        mid.val=Integer.MAX_VALUE;
        curr.left=build(head);
        return curr;
    }
   
    public TreeNode sortedListToBST(ListNode head) {
        return build(head);
    }
}