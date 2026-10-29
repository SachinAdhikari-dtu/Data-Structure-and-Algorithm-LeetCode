
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root==null)return null;
        // 2nd base case if we found some thing 
        if(root==p || root == q )return root;

        // deep call as we are totally dependent on previous data 
        TreeNode l= lowestCommonAncestor(root.left,p,q);
        TreeNode r= lowestCommonAncestor(root.right,p,q);

        //conditions 

        if(l!=null && r != null)return root;
        if(l!=null){
            return l;
        }
        
        return r;
       

    }
}