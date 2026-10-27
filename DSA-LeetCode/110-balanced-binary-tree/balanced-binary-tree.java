
class Solution {
    public static int h(TreeNode root , boolean arr[]){
        if(root==null)return 0;
        int l  = h(root.left , arr);
        int r=h(root.right ,arr);
        boolean ans=Math.abs(l-r)<=1;
        if(!ans){
            arr[0]=ans;
            return -1;
        }
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        boolean arr[]=new boolean[1];
        arr[0]=true;
        h(root,arr);
        return arr[0];
    }
}