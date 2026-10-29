
class Solution {
    public void helper(TreeNode root , int k , ArrayList<Integer> l ){
        if(root==null)return;
        helper(root.left,k,l);
        l.add(root.val);
        helper(root.right,k,l);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> l = new ArrayList<>();
        helper(root,k,l);
        return l.get(k-1);
    }
}