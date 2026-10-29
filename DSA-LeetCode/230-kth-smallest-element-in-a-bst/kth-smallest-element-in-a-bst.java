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
    public static void helper(TreeNode root , int k ,PriorityQueue<Integer> q  ){
        if(root==null)return;
        if(q.size()< k){
            q.offer(root.val);
        }else{
            if(q.peek() >  root.val){
                q.poll();
                q.offer(root.val);
            }
        }

        helper(root.left,k,q);
        helper(root.right,k,q);

    }
    public int kthSmallest(TreeNode root, int k) {
 PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        helper(root,k,q);
        return q.poll();

    }
}