
class Solution {
    public int maxLevelSum(TreeNode root) {
       int level=0;
       int maxLevel=-1;
       int maxValue=Integer.MIN_VALUE;
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;

            for(int i=0 ; i < size ; i++){
                TreeNode curr=q.poll();
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
                sum+=curr.val;
            }
            level++;
            if(sum > maxValue){
                maxValue=sum;
                maxLevel=level;
            }
        }

        return maxLevel;


    }
}