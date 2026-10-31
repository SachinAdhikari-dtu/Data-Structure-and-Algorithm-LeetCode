
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root,new int[]{k});
    }
        public int kthSmallest(TreeNode root, int k[]) {
        
        if(root==null)return Integer.MAX_VALUE;
        int l=kthSmallest(root.left,k);
        k[0]--;
        if(k[0]==0)return root.val;
        int r=kthSmallest(root.right,k);
      
        return Math.min(l,r);
        
    }
}