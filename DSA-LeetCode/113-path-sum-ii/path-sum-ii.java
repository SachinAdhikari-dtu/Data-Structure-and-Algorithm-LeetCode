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
    public static void helper(TreeNode root , int sum , List<Integer> l , List<List<Integer>> list){
        if(root==null)return;
        if(sum==root.val){
            if(root.left==null && root.right == null){
                l.add(root.val);
                list.add(new ArrayList<>(l));
                l.removeLast();
                return;
            }
        }
        l.add(root.val);
        helper(root.left,sum-root.val,l,list);
        helper(root.right,sum-root.val,l,list);

        l.removeLast();


    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> l = new ArrayList<>();
        helper(root,targetSum,new ArrayList<>() ,l);
        return l;
    }
}