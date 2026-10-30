
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode temp=root.left;
        TreeNode temp2=root.right;

        root.left=temp2;
        root.right=temp;

        root.left=invertTree(root.left);
        root.right=invertTree(root.right);

        return root;
        
    }
}