
class Solution {
    public static int find(int arr[] , int val){
        for(int i= 0 ; i < arr.length ; i++){
            if(arr[i]==val)return i;
        }
        return -1;
    }

    public static TreeNode helper(int in[] , int post[] , int s , int e , int index[]){
        if(index[0] < 0 || s >=e )return null;
        int val=post[index[0]];
        index[0]--;

        TreeNode curr=new TreeNode(val);

        int currIndex=find(in,val);

        curr.right=helper(in,post,currIndex+1,e,index);
        curr.left=helper(in,post,s,currIndex,index);

        return curr;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length , new int[]{inorder.length-1});
    }
}