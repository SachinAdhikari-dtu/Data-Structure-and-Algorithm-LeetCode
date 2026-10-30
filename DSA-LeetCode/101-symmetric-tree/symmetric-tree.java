
class Solution {
     public boolean help(TreeNode p , TreeNode q) {
        if(p==null && q== null)return true;
        if(p==null || q== null)return false;

        if(p.val!=q.val)return false;

        return help(p.left,q.right) && help(p.right,q.left);

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return help(root.left,root.right);
    }
}