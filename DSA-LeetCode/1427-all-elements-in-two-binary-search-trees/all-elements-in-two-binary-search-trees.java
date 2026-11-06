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
    public void helper(List<Integer> l , TreeNode root){
        if(root==null)return ;
        helper(l,root.left);
        l.add(root.val);
        helper(l,root.right);
    }
    public List<Integer> combine(List<Integer> l ,List<Integer> l1){
        int i=0;
        int j= 0;
        List<Integer> ans = new ArrayList<>();
        while( i < l.size() && j < l1.size()){
            if(l.get(i) > l1.get(j)){
                ans.add(l1.get(j++));
            }else{
                ans.add(l.get(i++));
            }
        }

        while( i < l.size() ){           
                ans.add(l.get(i++));
            }

        while(  j < l1.size()){   
                ans.add(l1.get(j++));
        }


        return ans;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();

        helper(l,root1);
        helper(l1,root2);

        return combine(l,l1);

    }
}