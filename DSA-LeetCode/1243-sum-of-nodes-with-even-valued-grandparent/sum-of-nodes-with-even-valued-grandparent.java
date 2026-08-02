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
    public static void help(TreeNode root , int ans[]){
        if(root==null)return ;
        if(root.val%2==0){
            if(root.left!=null)sum(root.left,ans);
            if(root.right!=null)sum( root.right , ans);
        }
        help(root.left,ans);
        help(root.right,ans);
    }
    public static void sum(TreeNode root , int ans[]){
        int s=0;
        if(root.left!=null)s+=root.left.val;
        if(root.right!=null)s+=root.right.val;
        ans[0]+=s;
    }
    public int sumEvenGrandparent(TreeNode root) {
        int ans[]=new int[1];
        ans[0]=0;

        help(root,ans);

        return ans[0];
    }
}