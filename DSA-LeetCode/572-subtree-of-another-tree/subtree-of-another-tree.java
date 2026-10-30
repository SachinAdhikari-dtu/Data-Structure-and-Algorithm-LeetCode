
class Solution {

        public boolean check(TreeNode q , TreeNode p){
            if(q==null && p== null)return true;
            if(q==null || p== null)return false;
            if(p.val != q.val)return false;
            return check(q.left,p.left)&&check(q.right,p.right);
        }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;

        if(root.val==subRoot.val){
            if(check(root,subRoot))return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}