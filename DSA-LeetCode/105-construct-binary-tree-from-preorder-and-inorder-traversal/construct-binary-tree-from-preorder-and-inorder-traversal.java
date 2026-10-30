
class Solution {
    public static int find(int arr[] , int val){
        for(int i= 0 ; i < arr.length ; i++){
            if(arr[i]==val)return i;

        }
        return -1;
    }
    public static TreeNode helper(int pre[] , int in[] , int s , int e , int index[]){
        if(index[0] >= in.length)return null;
        if(s >= e || s < 0 )return null;

        int val=pre[index[0]];
        index[0]++;

        TreeNode curr=new TreeNode(val);

        int currIndex=find(in,val);
        curr.left=helper(pre,in,s,currIndex,index);
        curr.right=helper(pre,in,currIndex+1,e,index);
        return curr;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int s=0;
        int e= preorder.length;
        int index[]=new int[1];

        return helper(preorder,inorder,s,e,index);
    }
}