
class Solution {

    public void helper(TreeNode root, ArrayList<Integer> l ){
        if(root==null)return;
        if(root.left==null && root.right==null){
            l.add(root.val);
            return;
        }
        helper(root.left,l);
        helper(root.right,l);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2= new ArrayList<>();
        helper(root1,l1);
        helper(root2,l2);
        if(l1.size()!=l2.size())return false;
        for(int i =0  ; i < l1.size() ; i++){
if(!l1.get(i).equals(l2.get(i))) return false;        }
        return true;
    }
}