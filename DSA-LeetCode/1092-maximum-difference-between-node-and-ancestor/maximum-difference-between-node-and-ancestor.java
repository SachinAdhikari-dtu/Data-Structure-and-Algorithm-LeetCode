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
    public int helper(int max , int min , TreeNode root){
        if(root==null)return 0;
        
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);
        int l=helper(max,min,root.left); 
        int r=helper(max,min,root.right); 
       int maxAns=max-min;

        return Math.max(Math.max(l,r),maxAns);
    }
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(helper(root.val,root.val,root.left),helper(root.val,root.val,root.right));
    }
}